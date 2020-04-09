package com.tensquare.friend.interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 李聪
 * @date 2020/2/18 17:14
 */

@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private JwtUtil jwtUtil;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("经过了拦截器");
        //无论如何都放行，能不能操作还是在具体的操作中去判断
        //拦截器只是把头请求中包含token的进行解析验证
        String header = request.getHeader("Authorization");
        System.out.println(header);
        if(header != null && !"".equals(header)) {
            //如果包含有Authorization头信息，就对其进行解析
            if(header.startsWith("Bearer ")) {
                //得到token
                String token = header.substring(7);
                //对令牌进行验证
                try{
                    Claims claims = jwtUtil.parseJWT(token);
                    System.out.println("解析后的claims:" + claims.toString());
                    String roles = (String) claims.get("roles");
                    if(roles != null || roles.equals("admin")) {
                       request.setAttribute("claims_admin",claims);
                    }
                    if(roles != null || roles.equals("user")) {
                        request.setAttribute("claims_user",claims);
                        request.setAttribute("666","去你码的");
                        Claims claims2 = (Claims) request.getAttribute("claims_user");
                        System.out.println("已经放入request:" + claims2);
                    }
                }catch(Exception e) {
                    throw new RuntimeException("令牌不正确!");
                }
            }
        }
        return true;
    }
}
