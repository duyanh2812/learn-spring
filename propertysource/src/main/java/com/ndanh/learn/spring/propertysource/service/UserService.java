package com.ndanh.learn.spring.propertysource.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Autowired
    Environment environment;

    @Value("${app.max.user}")
    String env;

    @Value("${test.property}")
    String testProperty;

//    @Value("${app.max.user}")
//    String maxUsers;

    public void getUser(){
        System.out.println(environment.getProperty("app.default.language"));
        System.out.println("Value environment + " + env);
        System.out.println("test property " + testProperty);
//        System.out.println("Max users " + maxUsers);
    }
}
