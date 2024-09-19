package com.ndanh.learn.spring.applicationcontext.util;

import com.ndanh.learn.spring.applicationcontext.provider.ApplicationContextProvider;
import com.ndanh.learn.spring.applicationcontext.service.UserService;
import org.springframework.context.ApplicationContext;

public class EmailUtil {
    public static void sendEmail(String from, String to, String msg){
        ApplicationContext applicationContext = ApplicationContextProvider.getAppCtx();
        UserService userService = applicationContext.getBean(UserService.class);
        userService.sendEmail(from, to, msg);
    }
}
