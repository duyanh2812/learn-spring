package com.ndanh.learn.spring.propertysource;

import com.ndanh.learn.spring.propertysource.config.AppConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import com.ndanh.learn.spring.propertysource.service.UserService;

@SpringBootApplication
public class PropertysourceApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(PropertysourceApplication.class, args);
//	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Environment env = ctx.getEnvironment();
		System.out.println(env.getProperty("email.port"));
		UserService userService = ctx.getBean(UserService.class);
		userService.getUser();
	}
}
