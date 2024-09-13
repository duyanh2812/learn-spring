package com.ndanh.learn.springaop.biz.impl;

import com.ndanh.learn.springaop.biz.UserBiz;
import com.ndanh.learn.springaop.customaspect.Loggable;
import com.ndanh.learn.springaop.vo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserBizImpl implements UserBiz {
    @Override
    @Loggable
    public User getUser(String userId) throws InterruptedException {
        System.out.println("Get user");
        Thread.sleep(1000);
        return new User("Duy Anh", "ndanh@partner.samsung.com", 34);
    }

    @Override
    public List<User> getUserList() throws InterruptedException {
        System.out.println("Get user list");
        Thread.sleep(1000);
        return List.of(new User("Duy Anh", "ndanh@partner.samsung.com", 34),
                new User("Thang", "thang.nm3@partner.samsung.com", 29),
                new User("Duc", "ntduc3@partner.samsung.com", 30),
                new User("Vu", "cmc.nvduy2@partner.samsung.com", 31));
    }
}
