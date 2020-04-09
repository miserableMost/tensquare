package com.tensquare.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

/**
 * @author 李聪
 * @date 2020/2/18 16:12
 */
public class ParseJwtTest {
    public static void main(String[] args) {
        Claims claims = Jwts.parser().setSigningKey("itcast")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE1ODIwMTQyNDksImV4cCI6MTU4MjAxNDMwOSwicm9sZSI6ImFkbWluIn0.5odmktz0H8GpTddOrvi36MWNpm-xHTdQu8o9PVZq48g")
                .getBody();
        System.out.println("用户id: " + claims.getId());
        System.out.println("用户名： "+claims.getSubject());
        System.out.println("登陆时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println("过期时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println("用户角色：" + claims.get("role"));

    }
}
