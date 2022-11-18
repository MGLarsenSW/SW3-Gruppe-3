package com.aau.gr3.controllers;

import com.aau.gr3.classes.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {
    @GetMapping("/ProjectOverview")
    String getProjects(Model model) {
        model.addAttribute("Projects", "AUUUGH");
        return "ProjectOverview";
    }
}

