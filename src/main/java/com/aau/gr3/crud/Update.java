package com.aau.gr3.crud;

import com.aau.gr3.classes.Scoring;
import com.aau.gr3.classes.State;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;

public class Update extends Crud {

    public Update(MongoDatabase mongoDatabase) {
        super(mongoDatabase);
    }

    // TODO: Consider refactoring these methods into a single method that takes a generic object as a parameter

    /**
     * Updates the state of a project
     * @param id - Supplier ID (ObjectID)
     * @param state - State object
     * @return - Returns true if the state was updated successfully otherwise false
     */
    public boolean updateSupplierState(ObjectId id, State state) {
        try {
            mongoDatabase.getCollection("Supplier").updateOne(new org.bson.Document("_id", id), new org.bson.Document("$set", new org.bson.Document("State", state)));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Updates the scoring of a project
     * @param supplierName - Supplier name (These will typically be unique)
     * @param scoring - Scoring object
     * @return - Returns true if the scoring was updated successfully otherwise false
     */
    public boolean updateSupplierScoring(String supplierName, Scoring scoring){
        try {
            mongoDatabase.getCollection("Supplier").updateOne(new org.bson.Document("supplierName", supplierName), new org.bson.Document("$set", new org.bson.Document("Scoring", scoring)));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
