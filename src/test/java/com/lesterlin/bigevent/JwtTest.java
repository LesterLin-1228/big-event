package com.lesterlin.bigevent;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

//    @Test
//    public void testGen(){
//        Map<String,Object> claims = new HashMap<>();
//        claims.put("id",1);
//        claims.put("username","Lester");
//        // 生成jwt代碼
//        String token = JWT.create()
//                .withClaim("user",claims) // 添加載荷
//                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*12)) // 添加過期時間12小時
//                .sign(Algorithm.HMAC256("lesterlin")); // 指定算法，配置密鑰
//        System.out.println(token);
//    }
//
//    @Test
//    public void testParse(){
//        // 定義字符串，模擬用戶傳遞過來的token
//        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6Ikxlc3RlciJ9LCJleHAiOjE3MDc0NDczNzV9.WTSua0t-x1DlEABQ0ZUoFDtvIrcf2p3Qss7oFNazu6k";
//
//        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("lesterlin")).build();
//
//        DecodedJWT decodedJWT = jwtVerifier.verify(token); // 驗證token，生成一個解析後的JWT對象
//        Map<String, Claim> claims = decodedJWT.getClaims();
//        System.out.println(claims.get("user"));
//
//        // 如果竄改head和payload則驗證失敗
//        // 如果竄改密鑰驗證失敗
//        // token過期驗證失敗
//    }
}
