package com.example.pokemon.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/user")
    public Map<String, Object> getUserInfo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return Map.of(
            "username", auth.getName(),
            "roles", auth.getAuthorities().toString()
        );
    }

    @GetMapping("/logout-success")
    public Map<String, String> logoutMessage() {
        return Map.of("message", "You have been logged out successfully!");
    }
}
