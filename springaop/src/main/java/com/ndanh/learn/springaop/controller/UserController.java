package com.ndanh.learn.springaop.controller;

import com.ndanh.learn.springaop.biz.UserBiz;
import com.ndanh.learn.springaop.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserBiz userBiz;
    @GetMapping(value = "/user")
    public User getUser() throws InterruptedException {
        return userBiz.getUser("1");
    }

    @GetMapping(value = "/user/all")
    public List<User> getUsers() throws InterruptedException {
        return userBiz.getUserList();
    }
}
