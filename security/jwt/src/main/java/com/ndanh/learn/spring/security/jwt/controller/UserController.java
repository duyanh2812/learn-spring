package com.ndanh.learn.spring.security.jwt.controller;

import com.ndanh.learn.spring.security.jwt.http.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/{id}")
    public UserResponse getUserById(String id) {
        return new UserResponse("username", "email");
    }
}
