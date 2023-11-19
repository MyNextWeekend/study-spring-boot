package com.example.studyspringboot;

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

    @Test
    public void genToken() {
        HashMap<String, Object> userInfo = new HashMap<>();
        userInfo.put("id", 1024);
        userInfo.put("name", "张三");
        String token = JWT.create()
                .withClaim("user", userInfo)
                .withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
                .sign(Algorithm.HMAC256(""));

        System.out.println(token);
    }

    @Test
    public void parseToken() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
                "eyJ1c2VyIjp7Im5hbWUiOiLlvKDkuIkiLCJpZCI6MTAyNH0sImV4cCI6MTcwMDMxMTMwMn0." +
                "H35vPKTFFn_NvrI8QpYWmwpdnQdEY_0VT21TP_V6CTo";

        JWTVerifier build = JWT.require(Algorithm.HMAC256("sadjflasdfl")).build();

        DecodedJWT decodedJWT = build.verify(token);    //验证token
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
    }
}
