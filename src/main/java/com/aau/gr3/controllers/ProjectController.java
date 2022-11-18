package com.aau.gr3.controllers;

import com.aau.gr3.classes.Overview;
import com.aau.gr3.crud.Read;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProjectController {
    @GetMapping("/ProjectOverview")
    String getProjects(Model model) {
        Read read = new Read();
        int project = 0;
        List<Overview> overviewList = read.getOverview();
        for (Overview overview : overviewList) {
            model.addAttribute("Project" + project, overview.get_id() + " - " + overview.getProjectName());
            model.addAttribute("Creation" + project, "Created: " + overview.getCreationDate());
            model.addAttribute("Deadline" + project, "Deadline: " + overview.getDeadlineDate());
            project++;
        }
        return "ProjectOverview";
    }
}

