package com.aau.gr3.crud;

import com.aau.gr3.util.Connection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Date;

public class Create extends Connection {
    /**
     * Creates a new project in the database
     * @param projectName - Name of the project
     * @param QADate - Date of the QA session
     * @param quotationDate - Date of the quotation
     * @param creationDate - Date of the creation
     * @param deadlineDate - Date of the deadline
     * @return - Returns true if the project was created successfully otherwise false
     */
    public boolean insertProject(String projectName, Date QADate, Date quotationDate, Date creationDate, Date deadlineDate){
        try {
            super.collection = super.database.getCollection("Project");
            collection.insertOne(new Document()
                    .append("_id", new Read().getNextID())
                    .append("projectName", projectName)
                    .append("QADate", QADate)
                    .append("quotationDate", quotationDate)
                    .append("creationDate", creationDate)
                    .append("deadlineDate", deadlineDate)
            );
            System.out.println("Project inserted successfully");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // TODO: Work in progress
    public boolean insertSupplier(int pid, String supply, String supplier, String contactPerson, String contactMail){
        try {
            super.collection = super.database.getCollection("Supplier");
            collection.insertOne(new Document()
                    .append("_id", new ObjectId())
                    .append("supply", supply)
                    .append("supplier", supplier)
                    .append("contactMail", contactMail)
                    .append("contactPerson", contactPerson)
                    .append("pid", pid)
                    .append("Scoring", null)
                    .append("State", null)
            );
            System.out.println("Supplier inserted successfully");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
