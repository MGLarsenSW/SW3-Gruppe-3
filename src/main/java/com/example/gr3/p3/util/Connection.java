package com.example.gr3.p3.util;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.FileReader;

public class Connection {
    protected MongoClient mongoClient;
    protected MongoDatabase database;
    protected MongoCollection<Document> collection;

    public Connection() {
    }
    public void close(){
        this.mongoClient.close();
        System.out.println("Connection closed");
    }
    public void establish(){
        String directory = "src/main/resources/ProviderName";

        try {
            BufferedReader br = new BufferedReader(new FileReader(directory));
            String URI = br.readLine();
            br.close();

            this.mongoClient = new MongoClient(new MongoClientURI(URI));
            System.out.println("Connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
