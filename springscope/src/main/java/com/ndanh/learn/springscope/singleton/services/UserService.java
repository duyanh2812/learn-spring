package com.ndanh.learn.springscope.singleton.services;

import com.ndanh.learn.springscope.singleton.components.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user-singleton")
public class UserService {
    CacheManager cacheManager;


    @Autowired
    public UserService(CacheManager cacheManager){
        this.cacheManager = cacheManager;
    }

    @GetMapping(value = "/all")
    public String getUsers(){
        return cacheManager.toString();
    }
}
