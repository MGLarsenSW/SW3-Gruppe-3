package com.example.gr3.p3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class P_Overview {
    @GetMapping
    String getProjects(Model model) {
        model.addAttribute("Projects", "This is the project overview");
        return "ProjectOverview";
    }
}
