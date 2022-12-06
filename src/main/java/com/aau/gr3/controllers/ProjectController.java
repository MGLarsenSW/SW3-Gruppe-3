package com.aau.gr3.controllers;

import com.aau.gr3.Constants;
import com.aau.gr3.classes.Email;
import com.aau.gr3.classes.Project;
import com.aau.gr3.classes.Supplier;
import com.aau.gr3.crud.Create;
import com.aau.gr3.crud.Read;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProjectController {
    @GetMapping("/ProjectOverview")
    String getProjects(Model model) {
        Read read = new Read();
        read.establish();
        model.addAttribute("Projects", read.getOverview());
        model.addAttribute("NextID", read.getNextID());
        read.close();
        return "ProjectOverview";
    }
    @RequestMapping(value = "/ProjectOverview", method = RequestMethod.POST)
    public String CreateProject(@ModelAttribute(name="project") Project project, Model model){
        Create create = new Create();
        create.establish();
        create.insertProject(project);
        create.close();
        return getProjects(model);
    }

    @GetMapping("/ProjectOverview/Archived")
    String getProjectsArchived(Model model) {
        Read read = new Read();
        read.establish();
        model.addAttribute("Projects", read.getOverview());
        model.addAttribute("NextID", read.getNextID());
        read.close();
        return "ProjectOverviewArchived";
    }

    @GetMapping("/Project/{id}")
    String getProject(@PathVariable("id") int id, Model model) {
        Read read = new Read();
        read.establish();
        List <Supplier> supplierList = read.getSupplierList(id);
        Email email = new Email(supplierList);
        model.addAttribute("supplierList", read.getSupplierList(id));
//        model.addAttribute("qaEmail", Constants.QAEmailTemplate);
//        model.addAttribute("reminderEmail", email.getReminderEmail());
//        model.addAttribute("email", email.getEmailList());
        model.addAttribute("reminderEmail", email.getReminderEmailList());
        System.out.println(email.getReminderEmailList());
//        model.addAttribute("reminderEmail", constants);
        read.close();
        return "ProjectPage";
    }
}
