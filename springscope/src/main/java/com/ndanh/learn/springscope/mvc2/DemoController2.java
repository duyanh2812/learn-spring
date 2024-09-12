package com.ndanh.learn.springscope.mvc2;

import com.ndanh.learn.springscope.model.ApplicationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController2 {
    @Autowired
    private ApplicationData applicationData;

    @GetMapping(value = "/demo2")
    public String getData(){

        return applicationData.toString();
    }
}
