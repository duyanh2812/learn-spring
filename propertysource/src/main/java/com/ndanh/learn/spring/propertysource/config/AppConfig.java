package com.ndanh.learn.spring.propertysource.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan(basePackages = {"com.ndanh.learn.spring.propertysource"})
@PropertySources({
    @PropertySource("application.properties"),
    @PropertySource("file:\\Users\\ngoduyanh\\Documents\\application_file.properties")
})
public class AppConfig {

}
