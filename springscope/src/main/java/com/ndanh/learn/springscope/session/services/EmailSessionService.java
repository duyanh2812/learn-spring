package com.ndanh.learn.springscope.session.services;

import com.ndanh.learn.springscope.session.components.SessionComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/email-session")
public class EmailSessionService {
    SessionComponent sessionComponent;
    @Autowired
    public EmailSessionService(SessionComponent sessionComponent){
        this.sessionComponent = sessionComponent;
    }

    @GetMapping(value = "/all")
    public String getEmails(){
        return sessionComponent.toString();
    }
}
