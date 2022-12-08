package com.aau.gr3.classes;

import java.util.ArrayList;
import java.util.List;

public class Email {
    private List<Supplier> supplierList;

    public Email(List<Supplier> supplierList) {
        this.supplierList = supplierList;
    }

//    public List<String> getEmailList() {
//        List<String> emailList = new ArrayList<>();
//        for (Supplier supplier : supplierList) {
////            emailList.add(getQAEmail(supplier));
////            emailList.add(getReminderEmail(supplier));
////            emailList.add(getDeadlineEmail(supplier));
//        }
//        return emailList;
//    }

    public List<String> getReminderEmailList() {
        List<String> emailList = new ArrayList<>();
        for (Supplier supplier : supplierList) {
            emailList.add("Dear " + supplier.getContactPerson() + ",\n" +
                    "A kind reminder that today is the deadline for the " + supplier.getSupply() + " package.\n" +
                    "Kind regards,\n" +
                    "{sourcing manager}");
        }
        return emailList;
    }

//    public String getDeadlineEmail(Supplier supplier) {
//        return "Dear {supplier contact person},\n" +
//                "A kind reminder that today is the deadline for the " + supplier.getSupply() + " package.\n" +
//                "Looking forward to receiving your quotation.\n" +
//                "Kind regards\n" +
//                "{sourcing manager}";
//    }
}
