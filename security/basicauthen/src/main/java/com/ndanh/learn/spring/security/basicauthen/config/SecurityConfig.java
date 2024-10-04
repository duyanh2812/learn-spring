package com.ndanh.learn.spring.security.basicauthen.config;

import com.ndanh.learn.spring.security.basicauthen.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/register", "/login", "/logout", "/css/**", "/js/**").permitAll() // Allow public access to login, register, and static resources
//                        .requestMatchers("/user/**").hasAnyAuthority("USER") // Allow access to user URLs only if the user has the USER role
                        .requestMatchers("/admin/**").hasAnyAuthority("ADMIN") // Allow access to admin URLs only if the user has the ADMIN role
                        .anyRequest().authenticated() // All other URLs require authentication
                )
                .formLogin(form -> form
                        .loginPage("/login") // Custom login page
                        .defaultSuccessUrl("/home", true) // Redirect to home after successful login
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Custom logout URL
                        .logoutSuccessUrl("/login?logout") // Redirect after successful logout
                        .invalidateHttpSession(true) // Invalidate session
                        .clearAuthentication(true) // Clear the authentication
                        .deleteCookies("JSESSIONID") // Delete session cookies
                        .permitAll()
                )
                .userDetailsService(customUserDetailsService()); // Enable basic authentication

        return http.build();
    }

    @Bean
    public CustomUserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Password encoding using BCrypt
    }
}
