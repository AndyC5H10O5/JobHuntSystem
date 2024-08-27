package com.final_pro.jobhuntsystem.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {
    // 7天过期
    private static long expire = 604800;
    // 32位密钥
    private static String secret = "gzhyhduxzazltjfhfepzgygoaswtjbjp";

    // 生成Token
    public static String generateToken(String username){
        Date now=new Date();
        Date expiration =new Date(now.getTime()+ 1000 * expire);
        return Jwts.builder()
                .setHeaderParam( "type","JWT")
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    //解析token，若解析无误，则返回一个正常的中间Payload对象
    public static Claims getClaimsByToken(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
