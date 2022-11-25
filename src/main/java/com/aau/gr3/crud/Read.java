package com.aau.gr3.crud;

import com.aau.gr3.classes.Overview;
import com.aau.gr3.classes.Project;
import com.aau.gr3.classes.Scoring;
import com.aau.gr3.classes.State;
import com.aau.gr3.util.Connection;
import com.mongodb.client.FindIterable;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class Read extends Connection{

    /**
     * Gets a list of all projects in the database
     * @return - Returns a list of Overview objects. Return null if there is no project(s)
     */
    public List<Overview> getOverview() {
        try {
            super.collection = super.database.getCollection("Project");
            List<Overview> overviewList = new ArrayList<>();

            // Create a projection to include only the fields we want
            Bson filter = Projections.fields(
                    Projections.include("projectName", "creationDate", "deadlineDate")
            );

            // Iterate through the documents in the collection and map them to the list<Overview>
            for (Document document : super.collection.find().projection(filter)) {
                overviewList.add(new Overview(
                        document.getInteger("_id"),
                        document.getString("projectName"),
                        document.getDate("creationDate"),
                        document.getDate("deadlineDate")
                        // TODO: Add image
                ));
            }

            return overviewList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

    /**
     * Gets a project from a specific id in the database
     * @param pid - Project ID
     * @return - Return a project object. Return null if the project does not exist
     */
    public Project getProject(int pid){
        try {
            super.collection = super.database.getCollection("Project");
            Document projectDocument = super.collection.find(eq("_id", pid)).first();

            return new Project(
                    projectDocument.getInteger("_id"),
                    projectDocument.getString("projectName"),
                    getSuppliers(pid),
                    projectDocument.getDate("deadlineDate"),
                    projectDocument.getDate("QADate")
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("No project found");
        return null;
    }
    // TODO : Only for testing currently
    public void printProject(Project projectDocument){
        System.out.println("ID: " + projectDocument.get_id());
        System.out.println("Project name: " + projectDocument.getProjectName());
        System.out.println("Supplier list: " + projectDocument.getSupplierList());
        System.out.println("Deadline date: " + projectDocument.getDeadlineDate());
        System.out.println("QAdate : " + projectDocument.getQADate());
    }

    /**
     * Gets a list of all suppliers from a specific project in the database
     * @param pid - Project ID
     * @return - Returns a list of suppliers objects. Return null if there is no supplier(s)
     */
    public List<State> getSuppliers(int pid){
        try {
            super.collection = super.database.getCollection("Supplier");
            List<State> supplierList = new ArrayList<>();

            // Create a projection to exclude Scoring Object
            Bson filter = Projections.fields(
                    Projections.exclude("Scoring")
            );

            FindIterable<Document> supplierListDocument = super.collection.find(eq("pid", pid)).projection(filter);

            // Iterate through the documents in the collection and map them to the list<State>
            for (Document supplier : supplierListDocument) {
                State supplierDocument = new State(
                        supplier.getObjectId("_id"),
                        supplier.getInteger("pid"),
                        supplier.getString("contactPerson"),
                        supplier.getString("contactMail"),
                        supplier.getString("supplier"),
                        supplier.getString("supply"),
                        supplier.get("State", Document.class).getBoolean("RFI"),
                        supplier.get("State", Document.class).getBoolean("tender"),
                        supplier.get("State", Document.class).getBoolean("quotation"),
                        supplier.get("State", Document.class).getBoolean("contract"),
                        supplier.get("State", Document.class).getBoolean("reminder"),
                        supplier.get("State", Document.class).getBoolean("QA")
                );
                supplierList.add(supplierDocument);
            return supplierList;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets a list of suppliers from a specific project id from the database
     * @param pid - Project ID
     * @param supply - Supply name
     * @return - Returns a list of Scoring objects. Return null if there is no supplier(s)
     */
    public List<Scoring> getScoring(int pid, String supply){
        try {
            super.collection = super.database.getCollection("Supplier");
            List<Scoring> scoringList = new ArrayList<>();

            // Exclude all State objects
            Bson filter = Projections.fields(
                    Projections.exclude("State")
            );

            // Find the supplier document with the given pid and supply
            Bson andComparsion = and(eq("pid", pid), eq("supply", supply));

            FindIterable<Document> scoringListDocument = super.collection.find(andComparsion).projection(filter);

            // Iterate through the documents in the collection and map them to the list<Scoring>
            for (Document scoring : scoringListDocument) {
                Scoring scoringDocument = new Scoring(
                        scoring.getObjectId("_id"),
                        scoring.getInteger("pid"),
                        scoring.getString("contactPerson"),
                        scoring.getString("contactMail"),
                        scoring.getString("supplier"),
                        scoring.getString("supply"),
                        scoring.get("Scoring", Document.class).getInteger("guarantee"),
                        scoring.get("Scoring", Document.class).getBoolean("csr"),
                        scoring.get("Scoring", Document.class).getString("siteErection"),
                        scoring.get("Scoring", Document.class).getInteger("price"),
                        scoring.get("Scoring", Document.class).getBoolean("board"),
                        scoring.get("Scoring", Document.class).getBoolean("travel"),
                        scoring.get("Scoring", Document.class).getInteger("score"));
                scoringList.add(scoringDocument);
            }
            return scoringList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets the highest project id value in the database and increments it by 1
     * @return - Returns the next project id. Return -1 if there is no project(s)
     */
    public int getNextID(){
        try {
            super.collection = super.database.getCollection("Project");

            Bson filter = Projections.fields(
                    Projections.include("_id")
            );

            return super.collection
                    .find()
                    .projection(filter)
                    .sort(new Document("_id", -1)) // Sort descending
                    .first() // Get the first document
                    .getInteger("_id") + 1; // Return the _id as int + 1
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
