package com.ndanh.learn.spring.security.basicauthen.entity;

import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User {
    private String username;
    private String password;

    private List<String> roles = List.of("USER");

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<GrantedAuthority> getRoles() {
        return List.of(new UserAuthority("USER"), new UserAuthority("ADMIN"));
    }
}
