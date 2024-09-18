package com.ndanh.learn.spring.lifecycle;

import com.ndanh.learn.spring.lifecycle.config.BeanConfig;
import com.ndanh.learn.spring.lifecycle.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@SpringBootApplication
public class LifecycleApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(LifecycleApplication.class, args);
//	}

	public static void main(String[] args) {
		ConfigurableApplicationContext secondAppCtx = new AnnotationConfigApplicationContext(BeanConfig.class);
		UserService userServicess = secondAppCtx.getBean(UserService.class);
		userServicess.getUser();
		secondAppCtx.close();
	}

}
