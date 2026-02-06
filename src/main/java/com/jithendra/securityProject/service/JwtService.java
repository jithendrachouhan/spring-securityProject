package com.jithendra.securityProject.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64.Decoder;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    public String generateToken(String username) {

        return Jwts
        .builder()
        .claims()
        .add(new HashMap<>())
        .subject(username)
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 30))
        .and()
        .signWith(getKey())
        .compact();

    }

    private Key getKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode("jiteehsfjseuhfueshr732yr723fr2ub4u2f2ufu24f"));
    }

}
