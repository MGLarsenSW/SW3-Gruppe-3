package com.aau.gr3.crud;

import com.aau.gr3.classes.Project;
import com.aau.gr3.classes.Supplier;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Create {

    private MongoDatabase mongoDatabase;

    public Create(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    // TODO: Consider refactoring these methods into a single method that takes a generic object as a parameter

    /**
     * Creates a new project in the database
     * @param project - Project object
     * @return - Returns true if the project was created successfully otherwise false
     */
    public boolean insertProject(Project project){
        try {
            MongoCollection<Project> projectCollection = mongoDatabase.getCollection("Project", Project.class);
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            project.setCreationDate(simpleDateFormat.format(new Date()));
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
            MongoCollection<Supplier> supplierCollection = mongoDatabase.getCollection("Supplier", Supplier.class);
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
