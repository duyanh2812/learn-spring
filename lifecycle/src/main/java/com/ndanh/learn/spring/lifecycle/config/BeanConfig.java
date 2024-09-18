package com.ndanh.learn.spring.lifecycle.config;

import com.ndanh.learn.spring.lifecycle.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.ndanh.learn.spring.lifecycle"})
public class BeanConfig {
    @Bean(initMethod = "init", destroyMethod = "Predestroy2")
    public UserService getUserService(){
        return new UserService();
    }
}
