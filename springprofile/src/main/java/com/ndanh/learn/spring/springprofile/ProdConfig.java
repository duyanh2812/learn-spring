package com.ndanh.learn.spring.springprofile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@Profile("prod")
@PropertySources({
        @PropertySource("email-prod.properties")
})
public class ProdConfig {
}
