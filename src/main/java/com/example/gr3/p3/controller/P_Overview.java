package com.example.gr3.p3.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class P_Overview {

    @RequestMapping("/ProjectOverview")
    public String getProjects(Model model) {
        model.addAttribute("project", "Graintec is very cool");
        return "ProjectOverview_View";
    }

}
