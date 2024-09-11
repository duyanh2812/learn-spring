package com.ndanh.learn.springscope.singleton.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    public AuthenticationService(CacheManager cacheManager){
        logger.info("AuthenticationService " + cacheManager.hashCode());
    };

    @GetMapping(value = "/all")
    public String getUsers(){
        return "Authentication";
    }
}
