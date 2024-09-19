package com.ndanh.learn.spring.applicationcontext;

import com.ndanh.learn.spring.applicationcontext.config.ApplicationConfig;
import com.ndanh.learn.spring.applicationcontext.service.UserService;
import com.ndanh.learn.spring.applicationcontext.util.EmailUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@SpringBootApplication
public class ApplicationcontextApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(ApplicationcontextApplication.class, args);
//	}

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

		applicationContext.registerShutdownHook();

		EmailUtil.sendEmail("Duy ANh", "Thang", "Hello thang");

	}

//	public static void main(String[] args) {
//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		UserService userService = applicationContext.getBean(UserService.class);
//		userService.getAllUsers();;
//	}

//	public static void main(String[] args) {
//		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("C:/applicationContext.xml")
//	}
}
