package com.ndanh.learn.springscope.request.services;

import com.ndanh.learn.springscope.request.components.RequestComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/email-request")
public class EmailRequestService {
    RequestComponent requestComponent;
    @Autowired
    public EmailRequestService(RequestComponent requestComponent){
        this.requestComponent = requestComponent;
    }

    @GetMapping(value = "/all")
    public String getEmails(){
        return requestComponent.toString();
    }
}
