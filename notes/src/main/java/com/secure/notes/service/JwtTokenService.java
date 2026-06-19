package com.secure.notes.service;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenService {

    public JwtTokenService() throws NoSuchAlgorithmException {
        KeyGenerator key=KeyGenerator.getInstance("HmacSHA256");

    }


    public String generatejwttoken(String username) {
        Map<String,Object> claims=new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() * 60 *60 *60))
                .and()
//                .signWith(getKey())
                .compact()



        return "";
    }
}
