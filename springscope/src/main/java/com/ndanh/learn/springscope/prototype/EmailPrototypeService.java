package com.ndanh.learn.springscope.prototype;

import com.ndanh.learn.springscope.common.components.PrototypeComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/email-prototype")
public class EmailPrototypeService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    public EmailPrototypeService(PrototypeComponent prototypeComponent){
        logger.info("EmailPrototypeService  PrototypeComponent" + prototypeComponent.hashCode());
    }

    @GetMapping(value = "/all")
    public String getEmails(){
        return "email-prototype";
    }
}
