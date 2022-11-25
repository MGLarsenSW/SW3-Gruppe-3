package com.aau.gr3.crud;

import com.aau.gr3.util.Connection;
import org.bson.Document;
import java.util.Date;

public class Create extends Connection {
    /**
     * Creates a new project in the database
     * @param projectName - Name of the project
     * @param QADate - Date of the QA
     * @param quotationDate - Date of the quotation
     * @param creationDate - Date of the creation
     * @param deadlineDate - Date of the deadline
     * @return - Returns true if the project was created successfully. Returns false if the project
     */
    public boolean insertProject(String projectName, Date QADate, Date quotationDate, Date creationDate, Date deadlineDate){
        try {
            super.collection = super.database.getCollection("Project");
            Read read = new Read();
            read.establish();
            collection.insertOne(new Document()
                    .append("_id", read.getNextID())
                    .append("projectName", projectName)
                    .append("QADate", QADate)
                    .append("quotationDate", quotationDate)
                    .append("creationDate", creationDate)
                    .append("deadlineDate", deadlineDate)
            );
            System.out.println("Project inserted successfully");
            read.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
