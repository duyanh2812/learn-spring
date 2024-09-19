package com.ndanh.learn.spring.applicationcontext.config;

import com.ndanh.learn.spring.applicationcontext.repository.UserRepository;
import com.ndanh.learn.spring.applicationcontext.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ndanh.learn.spring.applicationcontext"})
public class ApplicationConfig {

    @Bean
    public UserRepository userRepository(){
        return new UserRepository();
    }

    @Bean
    public UserService userService(){
        return new UserService(userRepository());
    }
}
