package com.ndanh.learn.spring.security.basicauthen.service.impl;

import com.ndanh.learn.spring.security.basicauthen.entity.User;
import com.ndanh.learn.spring.security.basicauthen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User findByUsername(String username) {
        // Fetch user details from database
        return new User("user", passwordEncoder.encode("password"));
    }

    @Override
    public void save(User user) {
        // Save user details to database
    }
}
