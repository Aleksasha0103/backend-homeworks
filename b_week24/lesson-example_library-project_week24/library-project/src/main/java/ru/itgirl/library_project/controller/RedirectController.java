package ru.itgirl.library_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {
    @GetMapping("/")
    public String redirectToSwagger() {
        return "redirect:/swagger-ui.html";
    }
}
