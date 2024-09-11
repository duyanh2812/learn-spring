package com.ndanh.learn.springscope.singleton.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/email")
@Scope(value = "session")
public class EmailService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    public EmailService(CacheManager cacheManager){
        logger.info("EmailService " + cacheManager.hashCode());
        logger.info("Email Scope " + this.hashCode());
    }

    @GetMapping(value = "/all")
    public String getEmails(){
        return "Emails";
    }
}
