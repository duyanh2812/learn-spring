package com.ndanh.learn.spring.springprofile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Value ("${email.from}")
    String emailFrom;
    @Value ("${email.to}")
    String emailTo;
    public UserService(){
        System.out.println("User Service created");
    }

    public void sendEmail(){
        System.out.println("Email sent from " + emailFrom + " to " + emailTo);
    }
}
