package com.ndanh.learn.spring.security.jwt.controller;

import com.ndanh.learn.spring.security.jwt.http.JwtRequest;
import com.ndanh.learn.spring.security.jwt.http.JwtResponse;
import com.ndanh.learn.spring.security.jwt.http.RefreshRequest;
import com.ndanh.learn.spring.security.jwt.service.MyUserDetailsService;
import com.ndanh.learn.spring.security.jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public JwtResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        final String fresh = jwtUtil.generateRefreshToken(userDetails.getUsername());
        System.out.println("Access token: " + jwt);
        System.out.println("Refresh token: " + fresh);
        return new JwtResponse(jwt, fresh);
    }

    @PostMapping("/refresh-token")
    public JwtResponse refreshAccessToken(@RequestBody RefreshRequest refreshRequest) {
        // Validate the refresh token and extract the username
        String username = jwtUtil.extractUsername(refreshRequest.getRefreshToken());
        if (username != null && !jwtUtil.isTokenExpired(refreshRequest.getRefreshToken())) {
            String newAccessToken = jwtUtil.generateToken(username);
            return new JwtResponse(newAccessToken, refreshRequest.getRefreshToken()); // Return the same refresh token
        } else {
            throw new RuntimeException("Invalid refresh token");
        }
    }
}
