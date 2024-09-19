package com.ndanh.learn.spring.springprofile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


public class Bean1 {
    public Bean1(){
        System.out.println("Bean1 created");
    }
}
