package com.ndanh.learn.spring.security.basicauthen.controller;

import com.ndanh.learn.spring.security.basicauthen.entity.User;
import com.ndanh.learn.spring.security.basicauthen.record.UserResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER') AND hasAuthority('ADMIN')")
    public UserResponse getUser(String userId) {
        return new UserResponse("user", "user@email.com");
    }
}
