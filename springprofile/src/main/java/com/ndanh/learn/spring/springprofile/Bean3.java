package com.ndanh.learn.spring.springprofile;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("Profile2")
public class Bean3 {
    public Bean3(){
        System.out.println("Bean3 created");
    }
}
