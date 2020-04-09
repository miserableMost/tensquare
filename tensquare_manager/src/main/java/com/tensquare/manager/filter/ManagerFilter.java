package com.tensquare.manager.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 李聪
 * @date 2020/2/19 15:01
 */
@Component
public class ManagerFilter extends ZuulFilter {

    @Autowired
    private JwtUtil jwtUtil;
    /**
     * 在请求前执行或者后执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 多个过滤器的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 当前过滤器是否开启true
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器内执行额操作 return 任何object的值表示继续执行
     * setsendzullResponse(false)  表示不再继续执行
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("经过后台过滤器了");
        RequestContext requestContext = RequestContext.getCurrentContext();
        //得到request域
        HttpServletRequest request = requestContext.getRequest();

        if(request.getMethod().equals("OPTIONS")) {
            System.out.println("登录的走了");
            return null;
        }
        //登录请求放行
        if(request.getRequestURI().indexOf("login") > 0) {
            System.out.println("登录信息放行");
            return null;
        }
        //得到头信息
        String header = request.getHeader("Authorization");
        System.out.println(header);
        if(header != null && !"".equals(header)) {
            if(header.startsWith("Bearer ")) {
                String token = header.substring(7);
                try{
                    Claims claims = jwtUtil.parseJWT(token);
                    String roles = (String) claims.get("roles");
                    if(roles.equals("admin")) {
                        //表示把头信息转发下去并且放行
                        requestContext.addZuulRequestHeader("Authorization",header);
                        System.out.println("把头信息放行了:" + header);
                        return null;
                    }
                }catch(Exception e) {
                    requestContext.setSendZuulResponse(false);  //终止运行
                    e.printStackTrace();
                }

            }
        }
        requestContext.setSendZuulResponse(false);  //终止运行
        requestContext.setResponseStatusCode(403);
        requestContext.setResponseBody("权限不足");
        requestContext.getResponse().setContentType("text/html,charset=utf-8");
        return null;
    }
}
