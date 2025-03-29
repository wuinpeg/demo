package com.example.pokemon.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/editor")
public class EditorController {

    @GetMapping
    @Secured("ROLE_EDITOR")
    public String editorDashboard() {
        return "Welcome, Editor! You have access to the editor dashboard.";
    }
}
