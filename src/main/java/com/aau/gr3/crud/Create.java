package com.aau.gr3.crud;

import com.aau.gr3.util.Connection;
import org.bson.Document;
import java.util.Date;

public class Create extends Connection {
    public boolean insertProject(String projectName, Date QADate, Date quotationDate, Date creationDate, Date deadlineDate){
        try {
            super.collection = super.database.getCollection("Project");

            try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
