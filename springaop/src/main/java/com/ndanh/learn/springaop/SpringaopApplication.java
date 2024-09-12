package com.ndanh.learn.springaop;

import com.ndanh.learn.springaop.biz.ShoppingCart;
import com.ndanh.learn.springaop.config.BeanConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringaopApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(SpringaopApplication.class, args);
//	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		ShoppingCart shoppingCart = context.getBean(ShoppingCart.class);
		shoppingCart.checkOutWithParam("Input Param");
		shoppingCart.quantity();
	}
}
