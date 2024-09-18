package com.ndanh.learn.spring.lifecycle.services;

import com.ndanh.learn.spring.lifecycle.biz.UserBiz;
import com.ndanh.learn.spring.lifecycle.biz.impl.UserBizImpl;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class UserService implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean {

    public UserService(){
        System.out.println("Create User Service Bean");
    }
    UserBiz userBiz;
    public UserService(UserBiz userBiz){
        this.userBiz = userBiz;
    }
    public void getUser(){
        System.out.println("hello user");
    }

    @Autowired
    public void setUserBiz(UserBiz userBiz) {
        System.out.println("Inject User Service Bean");
        this.userBiz = userBiz;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Set bean name: " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application context is " + applicationContext);
    }

    @PostConstruct
    public void testPostConstruct(){
        System.out.println("Post construct User Service Bean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init bean by afterPropertiesSet");
    }

    public void init() {
        System.out.println("Initialization through init method");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Clean up through @Predestroy");
    }

    public void Predestroy2(){
        System.out.println("Clean up through destroy method");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Clean up through disposable bean");
    }
}
