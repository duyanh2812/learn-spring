package com.ndanh.learn.spring.security.basicauthen.controller;

import com.ndanh.learn.spring.security.basicauthen.service.CustomLogoutSuccessHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jfr.Unsigned;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    CustomLogoutSuccessHandler customLogoutSuccessHandler;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Custom login page
    @GetMapping("/login")
    public String login() {
        return "custom-login";
    }

    @GetMapping("/home")
    public String loginSuccess() {
        return "home";
    }

    // Custom registration page
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
//        model.addAttribute("user", new UserDto()); // Provide a DTO for user registration
        return "register";
    }

    @PostMapping("/register")
    public String registerUser() {
        // Save the user with encoded password (this is simplified, you should add error handling)
//        userService.save(new User(userDto.getUsername(), passwordEncoder.encode(userDto.getPassword())));
        return "redirect:/login?register"; // Redirect to login page after successful registration
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        customLogoutSuccessHandler.onLogoutSuccess(request, response, authentication);
    }
}
