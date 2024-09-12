package com.ndanh.learn.springscope;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.ndanh.learn.springscope.mvc2", "com.ndanh.learn.springscope.model"})
public class Mvc2Config {
}
