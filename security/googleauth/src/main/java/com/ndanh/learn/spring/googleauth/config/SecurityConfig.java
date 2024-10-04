package com.ndanh.learn.spring.googleauth.config;

import com.ndanh.learn.spring.googleauth.service.CustomOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    CustomOAuth2UserService customOAuth2UserService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .requestMatchers("/", "/login").permitAll()  // Allow access to home and login page
                .anyRequest().authenticated()            // Protect all other endpoints
            )
//            .oauth2Login(oauth2 -> oauth2
//                .loginPage("/login")
//                .defaultSuccessUrl("/home", true));  // Redirect users to /home after successful login
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(customOAuth2UserService)
                        )
                );
        return http.build();
    }
}
