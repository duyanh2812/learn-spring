package com.ndanh.learn.spring.springprofile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"Profile1","Profile2"})
public class Bean5 {
    public Bean5(){
        System.out.println("Bean5 created");
    }
}
