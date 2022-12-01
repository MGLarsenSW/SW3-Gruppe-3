package com.aau.gr3.controllers;

import com.aau.gr3.classes.Supplier;
import com.aau.gr3.crud.Read;
import com.aau.gr3.util.Connection;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class ScoringController {
    @GetMapping("Project/{id}/Scoring/{supply}")
    String getSupply(@PathVariable("id") int id, @PathVariable("supply") String supply, Model model) {
        Read read = new Read(Connection.getInstance());
        List<Supplier> supplierList = read.getSupplierList(id);
        List<String> noDuplicates = Arrays.asList(supplierList.stream().map(Supplier::getSupply).distinct().toArray(String[]::new));
        model.addAttribute("supplyListNoDup", noDuplicates);
        model.addAttribute("supplyList", read.getSupplyList(id, supply));
        model.addAttribute("project", read.getProject(id));
        return "Scoring";
    }
}
