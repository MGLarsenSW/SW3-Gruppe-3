package com.aau.gr3.crud;

import com.aau.gr3.classes.Project;
import com.aau.gr3.classes.Supplier;
import com.aau.gr3.util.Connection;
import com.mongodb.client.MongoCollection;

public class Create extends Connection {

    // TODO: Consider refactoring these methods into a single method that takes a generic object as a parameter

    /**
     * Creates a new project in the database
     * @param project - Project object
     * @return - Returns true if the project was created successfully otherwise false
     */
    public boolean insertProject(Project project){
        try {
            MongoCollection<Project> projectCollection = database.getCollection("Project", Project.class);
            projectCollection.insertOne(project);
            System.out.println("Project created successfully");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Project creation failed");
        return false;
    }

    /**
     * Creates a new supplier in the database
     * @param supplier - Supplier object
     * @return - Returns true if the supplier was created successfully otherwise false
     */
    public boolean insertSupplier(Supplier supplier){
        try {
            MongoCollection<Supplier> supplierCollection = database.getCollection("Supplier", Supplier.class);
            supplierCollection.insertOne(supplier);
            System.out.println("Supplier created successfully");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Supplier creation failed");
        return false;
    }
}
