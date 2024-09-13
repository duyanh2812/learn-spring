package com.ndanh.learn.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Aspect
public class UserAspect {

//    @Pointcut("execution(* com.ndanh.learn.springaop.controller.*.*(..))")
//    public void executionPointCut(){}

//    @Pointcut("within(com.ndanh.learn.springaop.controller.*)")
//    public void withinPointCut(){}

//    @Pointcut("this(com.ndanh.learn.springaop.biz.impl.UserBizImpl)")
//    public void thisPointCut(){}
//
    @Pointcut("target(com.ndanh.learn.springaop.biz.UserBiz)")
    public void targetPointCut(){}

//    @Before("executionPointCut()")
//    public void beforeExecutionPointCut(JoinPoint jp){
//        System.out.println("executionPointCut " + jp.getSignature());
//    }

//    @Before("withinPointCut()")
//    public void beforeWithinPointCut(JoinPoint jp){
//        System.out.println("beforeWithinPointCut " + jp.getSignature());
//    }

//    @Before("thisPointCut()")
//    public void beforeThisPointCut(JoinPoint jp){
//        System.out.println("beforeThisPointCut " + jp.getSignature());
//    }
//
    @Before("targetPointCut()")
    public void beforeTargetPointCut(JoinPoint jp){
        System.out.println("beforeTargetPointCut " + jp.getSignature());
    }

    @After("targetPointCut()")
    public void afterTargetPointCut(JoinPoint jp){
        System.out.println("afterTargetPointCut " + jp.getSignature());
    }

    @Around("targetPointCut()")
    public Object aroundTargetPointCut(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aroundTargetPointCut " + pjp.getSignature());
        long start = System.nanoTime();
        Object retval = pjp.proceed();
        long end = System.nanoTime();
        String methodName = pjp.getSignature().getName();
        System.out.println("Execution of " + methodName + " took " +
                TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
        return retval;


    }

}
