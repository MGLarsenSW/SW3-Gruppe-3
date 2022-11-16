package com.example.gr3.p3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class P_Overview {

    @RequestMapping("/ProjectOverview")
    public String getProjects() {
        return "Project Overview";
    }

}
