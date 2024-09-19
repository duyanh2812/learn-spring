package com.ndanh.learn.spring.springprofile;

import org.springframework.context.annotation.*;

@Configuration
@Import({LocalConfig.class, QaConfig.class, ProdConfig.class})
@ComponentScan(basePackages = {"com.ndanh.learn.spring"})
public class AppConfig {

   @Bean
   @Profile("Profile1")
    public Bean1 getBean1(){
        return new Bean1();
    }

    @Bean
    @Profile("Profile2")
    public Bean2 getBean2(){
       return new Bean2();
    }
}
