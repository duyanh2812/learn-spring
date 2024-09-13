package com.ndanh.learn.springaop.biz;

import com.ndanh.learn.springaop.vo.User;

import java.util.List;

public interface UserBiz {
    public User getUser(String userId) throws InterruptedException;

    public List<User> getUserList() throws InterruptedException;
}
