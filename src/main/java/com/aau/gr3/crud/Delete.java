package com.aau.gr3.crud;

import com.aau.gr3.util.Connection;
import org.bson.types.ObjectId;

public class Delete extends Connection {

    // TODO: Consider refactoring these methods into a single method that takes an enum as a parameter

    /**
     * Deletes a project from the database
     * @param pid - Project ID
     * @return - Returns true if the project was deleted successfully otherwise false
     */
    public boolean deleteProject(int pid) {
        try {
            database.getCollection("Project").deleteOne(new org.bson.Document("_id", pid));
            System.out.println("Project deleted successfully");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Project deletion failed");
        return false;
    }

    /**
     * Deletes a supplier from the database
     * @param _id - Supplier ID (ObjectID)
     * @return - Returns true if the supplier was deleted successfully otherwise false
     */
    public boolean deleteSupplier(ObjectId _id) {
        try {
            database.getCollection("Supplier").deleteOne(new org.bson.Document("_id", _id));
            System.out.println("Supplier deleted successfully");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Supplier deletion failed");
        return false;
    }
}
