package com.ndanh.learn.spring.security.basicauthen.entity;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class UserAuthority implements GrantedAuthority{

    String role;

    public UserAuthority(String role) {
        this.role = role;
    }
    @Override
    public String getAuthority() {
        return this.role;
    }
}
