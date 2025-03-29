package com.example.pokemon.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    @Secured("ROLE_ADMIN")
    public String adminDashboard() {
        return "Welcome, Admin! You have access to the admin dashboard.";
    }
}
