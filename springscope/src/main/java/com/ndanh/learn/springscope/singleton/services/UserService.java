package com.ndanh.learn.springscope.singleton.services;

import com.ndanh.learn.springscope.common.components.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user-singleton")
public class UserService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    public UserService(CacheManager cacheManager){
        logger.info("UserService " + cacheManager.hashCode());
    }

    @GetMapping(value = "/all")
    public String getUsers(){
        return "user-singleton";
    }
}
