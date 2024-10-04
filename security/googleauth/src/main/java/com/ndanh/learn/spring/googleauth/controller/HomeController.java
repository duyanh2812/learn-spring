package com.ndanh.learn.spring.googleauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";  // Your home page
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        model.addAttribute("name", principal.getName());
        return "home";  // Your authenticated home page
    }

    @GetMapping("/login")
    public String login() {
        return "login";  // Your login page (can be a simple link to Google login)
    }
}
