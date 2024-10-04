package com.ndanh.learn.spring.security.basicauthen.service;

import com.ndanh.learn.spring.security.basicauthen.entity.User;

public interface UserService {
    User findByUsername(String username);
    void save(User user);
}
