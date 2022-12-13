package com.aau.gr3.controllers;

import com.aau.gr3.classes.Scoring;
import com.aau.gr3.classes.Supplier;
import com.aau.gr3.crud.Read;
import com.aau.gr3.crud.Update;
import com.aau.gr3.util.Connection;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class ScoringController {
    @GetMapping("Project/{pid}/Scoring/{supply}")
    String getSupply(@PathVariable("pid") int pid, @PathVariable("supply") String supply, Model model) {
        Read read = new Read(Connection.getInstance());
        List<Supplier> supplierList = read.getSupplierList(pid);
        List<String> noDuplicates = Arrays.asList(supplierList.stream().map(Supplier::getSupply).distinct().toArray(String[]::new));
        model.addAttribute("supplyListNoDup", noDuplicates);
        model.addAttribute("supplyList", read.getSupplyList(pid, supply));
        model.addAttribute("project", read.getProject(pid));
        return "Scoring";
    }
    @PostMapping("Project/{pid}/Scoring/{supply}/update/{supplierName}")
    String updateSupply(@PathVariable("pid") int pid, @PathVariable("supply") String supply, @PathVariable("supplierName") String supplierName, @ModelAttribute("scoring") Scoring scoring, Model model) {
        Update update = new Update(Connection.getInstance());
        update.updateSupplierScoring(supplierName, scoring);
        System.out.println("Guarantee:" + scoring.getGuarantee());
        System.out.println("CSR:" + scoring.isCsr());
        System.out.println("Travel cost:" + scoring.isTravel());
        System.out.println("Site Erection:" + scoring.getSiteErection());
        System.out.println("Price:" + scoring.getPrice());
        System.out.println("Board:" + scoring.isBoard());
        System.out.println("Legal T&C's:" + scoring.getTc());
        System.out.println("Score:" + scoring.getScore());
        return "redirect:/Project/" + pid + "/Scoring/" + supply;
    }
}
