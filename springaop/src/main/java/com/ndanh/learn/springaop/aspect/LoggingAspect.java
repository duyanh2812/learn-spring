package com.ndanh.learn.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

    @Before("execution(* com.ndanh.learn.springaop.biz.ShoppingCart.checkOut())")
    public void beforeLog(){
        System.out.println("before checkout");
    }

    @After("execution(* com.ndanh.learn.springaop.*.*.checkOut())")
    public void afterLog(){
        System.out.println("after checkout");
    }

    @Before("execution(* com.ndanh.learn.springaop.biz.ShoppingCart.checkOutWithParam(..))")
    public void beforeLogWithParam(JoinPoint jp){
        System.out.println(Arrays.stream(jp.getArgs()).sorted().toList());
        System.out.println("before checkout with param");
    }

    @After("execution(* com.ndanh.learn.springaop.*.*.checkOutWithParam(..))")
    public void afterLogWithParam(){
        System.out.println("after checkout with param");
    }

    @Pointcut("execution(* com.ndanh.learn.springaop.biz.ShoppingCart.quantity(..))")
    public void afterReturningPointCut(){

    }

    @AfterReturning(pointcut = "execution(* com.ndanh.learn.springaop.biz.ShoppingCart.quantity(..))", returning = "retVal")
    public void afterReturning(String retVal){
        System.out.println("After returning " + retVal);
    }
}
