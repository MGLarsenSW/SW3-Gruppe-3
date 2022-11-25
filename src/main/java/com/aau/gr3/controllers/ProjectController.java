package com.aau.gr3.controllers;

import com.aau.gr3.crud.Read;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {
    @GetMapping("/ProjectOverview")
    String getProjects(Model model) {
        Read read = new Read();
        read.establish();
        model.addAttribute("Projects", read.getOverview());
        read.close();
        return "ProjectOverview";
    }
}

