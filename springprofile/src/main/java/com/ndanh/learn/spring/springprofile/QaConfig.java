package com.ndanh.learn.spring.springprofile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@Profile("qa")
@PropertySources({
        @PropertySource("email-qa.properties")
})
public class QaConfig {
}
