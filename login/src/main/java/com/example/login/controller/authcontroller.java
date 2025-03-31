package com.example.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Return the login.html template
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Simple authentication logic (for demo only)
        if ("admin".equals(username) && "12345".equals(password)) {
            return "redirect:/home"; // Redirect to home page (not yet implemented)
        }
        return "login"; // Return to login page if authentication fails
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register"; // Return the register.html template
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        // Registration logic (for demo only, not saving to database yet)
        System.out.println("Registered: " + username + ", " + email + ", " + password);
        return "redirect:/login"; // Redirect to login page after registration
    }
}