package com.ndanh.learn.spring.security.basicauthen.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, IOException {
        // Debugging information
        System.out.println("User has logged out: " + (authentication != null ? authentication.getName() : "anonymous"));

        // Check session invalidation
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidate session explicitly
            System.out.println("Session invalidated.");
        }

        // Redirect after logout
        response.sendRedirect("/login?logout");
    }
}
