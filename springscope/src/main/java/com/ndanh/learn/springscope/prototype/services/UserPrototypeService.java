package com.ndanh.learn.springscope.prototype.services;

import com.ndanh.learn.springscope.prototype.components.PrototypeComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user-prototype")
public class UserPrototypeService {
    PrototypeComponent prototypeComponent;


    @Autowired
    public UserPrototypeService(PrototypeComponent prototypeComponent){
        this.prototypeComponent = prototypeComponent;
    }

    @GetMapping(value = "/all")
    public String getUsers(){
        return prototypeComponent.toString();
    }
}
