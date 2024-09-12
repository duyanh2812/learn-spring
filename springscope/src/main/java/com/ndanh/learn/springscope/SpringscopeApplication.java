package com.ndanh.learn.springscope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ndanh.learn.springscope.mvc", "com.ndanh.learn.springscope.model"})
public class SpringscopeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringscopeApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean mvc2(){
		AnnotationConfigWebApplicationContext secondAppCtx = new AnnotationConfigWebApplicationContext();
		secondAppCtx.register(Mvc2Config.class);

		DispatcherServlet dispatcherServlet = new DispatcherServlet();
		dispatcherServlet.setApplicationContext(secondAppCtx);

		DispatcherServletRegistrationBean servletRegistrationBean = new DispatcherServletRegistrationBean(dispatcherServlet, "/second/*");
		servletRegistrationBean.setName("second");
		return servletRegistrationBean;

	}
}
