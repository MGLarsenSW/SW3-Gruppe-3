package com.aau.gr3.controllers;

import com.aau.gr3.classes.Overview;
import com.aau.gr3.crud.Read;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProjectController {
    @GetMapping("/ProjectOverview")
    String getProjects(Model model) {
        Read read = new Read();
        model.addAttribute("Projects", read.getOverview());
        return "ProjectOverview";
    }
}

