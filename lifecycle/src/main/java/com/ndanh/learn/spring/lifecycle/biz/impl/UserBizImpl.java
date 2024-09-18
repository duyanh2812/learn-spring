package com.ndanh.learn.spring.lifecycle.biz.impl;

import com.ndanh.learn.spring.lifecycle.biz.UserBiz;
import org.springframework.stereotype.Component;

@Component
public class UserBizImpl implements UserBiz {
    @Override
    public void someBusiness() {
        System.out.println("Some business");
    }
}
