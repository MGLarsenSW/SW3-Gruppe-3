package com.aau.gr3.util;

import com.aau.gr3.classes.State;
import com.aau.gr3.crud.Read;
import com.aau.gr3.classes.Scoring;

import java.util.List;


public class main {
    public static void main(String[] args) {
        Read read = new Read();
        read.establish();
        read.printOverview(read.getOverview());
        read.printProject(read.getProject(1));
        List<State> supplierList = read.getSuppliers(1);
        System.out.println(supplierList.get(0).get_id());
        System.out.println(supplierList.get(0).getPid());
        System.out.println(supplierList.get(0).getSupplier());
        System.out.println(supplierList.get(0).getSupply());
        System.out.println(supplierList.get(0).getContactPerson());
        System.out.println(supplierList.get(0).getContactMail());

        List<Scoring> scoring = read.getScoring(1, "Steel");
        System.out.println(scoring.get(0).getSupplier());
        System.out.println(scoring.get(0).getSupply());
        System.out.println(scoring.get(0).getScore());
        System.out.println(scoring.get(0).getPrice());
        System.out.println(scoring.get(0).getGuarantee());
        read.close();
    }
}
