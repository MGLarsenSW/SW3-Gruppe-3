package com.example.gr3.p3.crud;

import com.example.gr3.p3.classes.Overview;
import com.example.gr3.p3.classes.Project;
import com.example.gr3.p3.classes.Supplier;
import com.example.gr3.p3.util.Connection;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class Read extends Connection{
    public List<Overview> getOverview() {
        List<Overview> overviewList = new ArrayList<>();

        try {
            super.database = super.mongoClient.getDatabase("graintec");
            super.collection = super.database.getCollection("Project");

            // Create a projection to include only the fields we want
            Bson filter = Projections.fields(
                    Projections.include("projectName", "creationDate", "deadlineDate")
            );

            // Iterate through the documents in the collection and add them to the list<Overview>
            for (Document document : super.collection.find().projection(filter)) {
                overviewList.add(new Overview(
                        document.getInteger("_id"),
                        document.getString("projectName"),
                        document.getDate("creationDate"),
                        document.getDate("deadlineDate")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return overviewList;
    }
    // TODO: Only for testing currently
    public void printOverview(List<Overview> list){
        for (Overview overview : list) {
            System.out.println("ID: " + overview.get_id());
            System.out.println("Project name: " + overview.getProjectName());
            System.out.println("Creation date: " + overview.getCreationDate());
            System.out.println("Deadline date: " + overview.getDeadlineDate());
        }
    }
    public Project getProject(int _id){
        try {
            super.database = super.mongoClient.getDatabase("graintec");
            super.collection = super.database.getCollection("Project");
            Document projectDocument = super.collection.find(eq("_id", _id)).first();

            return new Project(projectDocument.getInteger("_id"), projectDocument.getString("projectName"),
                getSuppliers(_id), projectDocument.getDate("deadlineDate"), projectDocument.getDate("QADate"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("No project found");
        return null;
    }
    //TODO : Only for testing currently
    public void printProject(Project projectDocument){
        System.out.println("ID: " + projectDocument.get_id());
        System.out.println("Project name: " + projectDocument.getProjectName());
        System.out.println("Supplier list: " + projectDocument.getSuppliers());
        System.out.println("Deadline date: " + projectDocument.getDeadlineDate());
        System.out.println("QAdate : " + projectDocument.getQADate());
    }
    public List<Supplier> getSuppliers(int pid){
        List<Supplier> supplierList = new ArrayList<>();

        try {
            super.database = super.mongoClient.getDatabase("graintec");
            super.collection = super.database.getCollection("Supplier");

            FindIterable<Document> supplierListDocument = super.collection.find(eq("pid", pid));

            for (Document supplier : supplierListDocument) {
                Supplier supplierDocument = new Supplier(supplier.getObjectId("_id"), supplier.getInteger("pid"), supplier.getString("contactPerson"),
                        supplier.getString("contactMail"), supplier.getString("supplier"), supplier.getString("supply"),
                        supplier.getBoolean("stateRFI"), supplier.getBoolean("stateTender"), supplier.getBoolean("stateQuotation"),
                        supplier.getBoolean("stateContract"), supplier.getBoolean("stateReminder"), supplier.getBoolean("stateQA"));
                supplierList.add(supplierDocument);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return supplierList;
    }
}
