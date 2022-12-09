package com.aau.gr3.controllers;

import com.aau.gr3.classes.Email;
import com.aau.gr3.classes.Project;
import com.aau.gr3.classes.Scoring;
import com.aau.gr3.classes.State;
import com.aau.gr3.classes.Supplier;
import com.aau.gr3.crud.Create;
import com.aau.gr3.crud.Delete;
import com.aau.gr3.crud.Read;
import com.aau.gr3.util.Connection;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProjectController {
    @GetMapping("/ProjectOverview")
    String getProjects(Model model) {
        Read read = new Read(Connection.getInstance());
        model.addAttribute("Projects", read.getOverview());
        model.addAttribute("NextID", read.getNextID());
        return "ProjectOverview";
    }
    @RequestMapping(value = "/ProjectOverview", method = RequestMethod.POST)
    String CreateProject(@ModelAttribute(name="project") Project project, Model model){
        Create create = new Create(Connection.getInstance());
        create.insertProject(project);
        return getProjects(model);
    }

    @GetMapping("/ProjectOverview/Archived")
    String getProjectsArchived(Model model) {
        Read read = new Read(Connection.getInstance());
        model.addAttribute("Projects", read.getOverview());
        model.addAttribute("NextID", read.getNextID());
        return "ProjectOverviewArchived";
    }

    @GetMapping("/Project/{id}")
    String getProject(@PathVariable("id") int id, Model model) {
        Read read = new Read(Connection.getInstance());
        List<Supplier> supplierList = read.getSupplierList(id);
        List<String> noDuplicates = Arrays.asList(supplierList.stream().map(Supplier::getSupply).distinct().toArray(String[]::new));
        model.addAttribute("supplyListNoDup", noDuplicates);
        model.addAttribute("supplierList", read.getSupplierList(id));
        model.addAttribute("project", read.getProject(id));
        model.addAttribute("nextObjId", new ObjectId());
        return "ProjectPage";
    }
    @RequestMapping(value = "/Project/{id}", method = RequestMethod.POST)
    String CreateSupplier(@PathVariable("id") int id, @ModelAttribute(name="supplier") Supplier supplier, Model model) {
        Create create = new Create(Connection.getInstance());
        supplier.setScoring(new Scoring());
        supplier.setState(new State());
        create.insertSupplier(supplier);
        return getProject(id, model);
    }
    @GetMapping(value = "/Project/{pid}/remove/{id}")
    String DeleteSupplier(@PathVariable("pid") int pid, @PathVariable("id") ObjectId id, Model model) {
        Delete delete = new Delete(Connection.getInstance());
        delete.deleteSupplier(id);
        return getProject(pid, model);
    }
}
