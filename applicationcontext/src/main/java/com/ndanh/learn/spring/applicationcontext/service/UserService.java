package com.ndanh.learn.spring.applicationcontext.service;

import com.ndanh.learn.spring.applicationcontext.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void getAllUsers(){
        System.out.println(userRepository.toString());
    }
}
