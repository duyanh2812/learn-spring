package com.ndanh.learn.spring.springprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class SpringprofileApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(SpringprofileApplication.class, args);
//	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		ConfigurableEnvironment env = appContext.getEnvironment();
//
		env.setActiveProfiles("dev");
		appContext.register(AppConfig.class);
		appContext.refresh();
        UserService userService = appContext.getBean(UserService.class);
        userService.sendEmail();;

	}

//    public static void main(String[] args) {
//        ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");
////		ConfigurableEnvironment env = appContext.getEnvironment();
//////
////		env.setActiveProfiles("local");
////		appContext.regis
////		appContext.refresh();
//
//		UserService userService = appContext.getBean(UserService.class);
//        userService.sendEmail();;
//    }

}
