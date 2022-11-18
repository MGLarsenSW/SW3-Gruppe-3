package com.aau.gr3.crud;

import com.example.gr3.p3.classes.Overview;
import com.example.gr3.p3.classes.Project;
import com.example.gr3.p3.classes.Supplier;
import com.example.gr3.p3.util.Connection;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Read {
    public List<Overview> getOverview(){
        List<Overview> overviewList = new ArrayList<>();

        try {
            Connection connection = new Connection();
            connection.establish();
            MongoCollection<Document> document = connection.read("Project");

            for (Document doc : document.find()) {
                Overview overview = new Overview(doc.getInteger("_id"), doc.getString("projectName"),
                        doc.getDate("creationDate"), doc.getDate("deadlineDate"));

                overviewList.add(overview);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return overviewList;
    }

    public void printOverview(List<Overview> list){
        for (Overview overview : list) {
            System.out.println("ID: " + overview.get_id());
            System.out.println("Project name: " + overview.getProjectName());
            System.out.println("Creation date: " + overview.getCreationDate());
            System.out.println("Deadline date: " + overview.getDeadlineDate());
        }
    }

    public void getProject(){
        try {
            Connection connection = new Connection();
            connection.establish();
            MongoCollection<Document> document = connection.read("Project");
            MongoCollection<Document> supplier = connection.read("Supplier");

            for (Document doc : document.find()) {
                Project project = new Project(doc.getInteger("_id"), doc.getString("projectName"), doc.getString("supply"),
                        doc.getString("supplier"), doc.getString("contactMail"), doc.getString("contactPerson"),
                        doc.getDate("deadlineDate"), doc.getDate("QADate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
    public void printOverview(){
        System.out.println("ID: " + project.get_id());
        System.out.println("Project name: " + project.getProjectName());
        System.out.println("Supply: " + project.getSupply());
        System.out.println("Supplier: " + project.getSupplier());
        System.out.println("Contact mail: " + project.getContactMail());
        System.out.println("Contact person: " + project.getContactPerson());
        System.out.println("Deadline date: " + project.getDeadlineDate());
        System.out.println("QA date: " + project.getQADate());
        System.out.println("RFI: " + project.isStateRFI());
        System.out.println("Tender: " + project.isStateTender());
        System.out.println("QA: " + project.isStateQA());
        System.out.println("Reminder: " + project.isStateReminder());
        System.out.println("Quotation: " + project.isStateQuotation());
        System.out.println("Contract: " + project.isStateContract());
    }*/
}
