package com.ndanh.learn.springscope.prototype;

import com.ndanh.learn.springscope.common.components.PrototypeComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user-prototype")
public class UserPrototypeService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    public UserPrototypeService(PrototypeComponent prototypeComponent){
        logger.info("UserPrototypeService  PrototypeComponent" + prototypeComponent.hashCode());
    }

    @GetMapping(value = "/all")
    public String getEmails(){
        return "user-prototype";
    }
}
