package com.ndanh.learn.springaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

    @Pointcut("within(com.ndanh.learn.springaop.biz.*)")
    public void authenticationPointCut(){
        System.out.println("authenticationPointCut");
    }

    @Pointcut("within(com.ndanh.learn.springaop.biz.*)")
    public void authorizationPointCut(){
        System.out.println("authorizationPointCut");
    }

    @Before("authenticationPointCut() && authorizationPointCut()")
    public void authenticate(){
        System.out.println("The request is authenticating");
    }
}
