package com.aau.gr3.crud;

import com.aau.gr3.classes.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class Read extends Crud {
    public Read(MongoDatabase mongoDatabase) {
        super(mongoDatabase);
    }

    /**
     * Gets a list of all projects in the database
     * @return - Returns a list of Overview objects. Return null if there is no project(s)
     */
    public List<Project> getOverview() {
        try {
            MongoCollection<Project> projectCollection = mongoDatabase.getCollection("Project", Project.class);
            List<Project> overviewList = new ArrayList<>();

            // Include only used fields for the overview
            Bson filter = Projections.fields(
                    Projections.include("image" ,"_id", "projectName", "creationDate", "deadlineDate")
            );
            projectCollection.find().projection(filter).sort(new Document("_id", -1)).into(overviewList);

            return overviewList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // TODO: Only for testing currently
    public void printOverview(List<Project> list){
        for (Project project : list) {
            System.out.println("ID: " + project.getId());
            System.out.println("Project name: " + project.getProjectName());
            System.out.println("Creation date: " + project.getCreationDate());
            System.out.println("Deadline date: " + project.getDeadlineDate());
        }
    }

    /**
     * Gets a project from a specific id in the database
     * @param pid - Project ID
     * @return - Return a project object. Return null if the project does not exist
     */
    public Project getProject(int pid){
        try {
            MongoCollection<Project> projectCollection = mongoDatabase.getCollection("Project", Project.class);

            // Find the project with the specific id
            Project project = projectCollection.find(eq("_id", pid)).first();

            return project;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("No project found");
        return null;
    }

    /**
     * Gets a supplier from a specific Object id in the database
     * @param id - Object ID
     * @return - Return a supplier object. Return null if the supplier does not exist
     */
    public Supplier getSupplier(ObjectId id){
        try {
            MongoCollection<Supplier> supplierCollection = mongoDatabase.getCollection("Supplier", Supplier.class);

            // Find the project with the specific id
            Supplier supplier = supplierCollection.find(eq("_id", id)).first();

            return supplier;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("No project found");
        return null;
    }

    // TODO : Only for testing currently
    public void printProject(Project project){
        System.out.println("ID: " + project.getId());
        System.out.println("Project name: " + project.getProjectName());
        System.out.println("Deadline date: " + project.getDeadlineDate());
        System.out.println("Creation date: " + project.getCreationDate());
        System.out.println("Quotation date: " + project.getQuotationDate());
        System.out.println("QA date: " + project.getQaDate());
    }

    /**
     * Gets a list of all suppliers in the database
     * @param pid - Project ID
     * @return - Returns a list of Supplier objects. Return null if there is no supplier(s)
     */
    public List<Supplier> getSupplierList(int pid){
        try {
            MongoCollection<Supplier> supplierCollection = mongoDatabase.getCollection("Supplier", Supplier.class);
            List<Supplier> supplierList = new ArrayList<>();

            // Find all suppliers with the specific project id
            supplierCollection.find(eq("pid", pid)).into(supplierList);

            for (Supplier supplier : supplierList) {
                supplier.getState().calculatePercentage();
            }


            return supplierList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("No supplier found");
        return null;
    }

    /**
     * Gets a list of supply items from a specific supplier in the database
     * @param pid - Project ID
     * @param supply - Supply as a string
     * @return - Returns a list of Supply objects. Return null if there is no supply item(s)
     */
    public List<Supplier> getSupplyList(int pid, String supply){
        try {
            MongoCollection<Supplier> supplierCollection = mongoDatabase.getCollection("Supplier", Supplier.class);
            List<Supplier> supplyList = new ArrayList<>();

            Bson filter = Projections.fields(
                    Projections.exclude("State")
            );

            // Find all suppliers with the specific project id and supply
            Bson andComparison = and(eq("pid", pid), eq("supply", supply));

            supplierCollection.find(andComparison).projection(filter).into(supplyList);

            return supplyList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("No supply found");
        return null;
    }

    // TODO : Only for testing currently
    public void printSupplierList(List<Supplier> list){
        for (Supplier supplier : list){
            System.out.println("Supplier ID: " + supplier.getId());
            System.out.println("Project ID: " + supplier.getPid());
            System.out.println("Contact person: " + supplier.getContactPerson());
            System.out.println("Contact mail: " + supplier.getContactMail());
            System.out.println("Supplier name: " + supplier.getSupplierName());
            System.out.println("Supply: " + supplier.getSupply());

            if (supplier.getState() != null){
                System.out.println("State: " + supplier.getState());
                System.out.println(" -> QA: " + supplier.getState().isQa());
                System.out.println(" -> Quotation: " + supplier.getState().isScoring());
                System.out.println(" -> Contract: " + supplier.getState().isContract());
                System.out.println(" -> RFI: " + supplier.getState().isRfi());
                System.out.println(" -> Quotation: " + supplier.getState().isScoring());
            }

            if (supplier.getScoring() != null) {
                System.out.println("Scoring: " + supplier.getScoring());
                System.out.println(" -> Price: " + supplier.getScoring().getPrice());
                System.out.println(" -> Score: " + supplier.getScoring().getScore());
            }
        }
    }

    /**
     * Gets the highest project ID integer in the database and increments it by 1
     * @return - Returns the next project ID. Return 1 by default
     */
    public int getNextID(){
        try{
            MongoCollection<Project> projectCollection = mongoDatabase.getCollection("Project", Project.class);

            // Include only the project id field
            Bson filter = Projections.fields(
                    Projections.include("_id")
            );

            return projectCollection
                    .find()
                    .projection(filter)
                    .sort(new Document("_id", -1)) // Sort by _id descending
                    .first()
                    .getId() + 1; // Return the highest _id + 1
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
}
