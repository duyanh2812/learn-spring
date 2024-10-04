package com.ndanh.learn.spring.security.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

@Component
public class JwtUtil {

    @Value("${key.secret}")
    String secretKey;
//    private SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long accessTokenValidity = 1000 * 60 * 15; // 15 minutes
    private final long refreshTokenValidity = 1000 * 60 * 60 * 24 * 7; // 7 days

    private SecretKey getSecretKey(){
        byte[] keyBytes = Base64.getDecoder().decode(secretKey);
        return new SecretKeySpec(keyBytes, 0, keyBytes.length, "HmacSHA256");
    }
    // Method to extract the username (subject) from the JWT token
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();  // The subject contains the username
    }

    // Method to extract all claims from the JWT token
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSecretKey())  // Set the key for verifying the token
                .build()
                .parseClaimsJws(token)  // Parse the token and get the Claims
                .getBody();
    }

    // Method to validate the token against the username
    public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);  // Extract username from token
        return (extractedUsername.equals(username) && !isTokenExpired(token));  // Compare and check expiry
    }

    // Method to check if the token is expired
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Method to extract the expiration date from the JWT token
    private Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username, accessTokenValidity);
    }

    public String generateRefreshToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username, refreshTokenValidity);
    }

    public List extractRoles(String token) {
        Claims claims = extractAllClaims(token);
        return claims.get("roles", List.class); // Extract roles from the claims
    }


    private String createToken(Map<String, Object> claims, String subject, long expire ) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expire)) // 10 hours expiration
                .signWith(getSecretKey(), SignatureAlgorithm.HS256)  // Use SecretKey and SignatureAlgorithm
                .compact();
    }
}
