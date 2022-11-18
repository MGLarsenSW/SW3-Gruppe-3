package com.aau.gr3.util;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.FileReader;

public class Connection {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public Connection() {
    }

    public MongoCollection<Document> read(String collection){
        this.database = mongoClient.getDatabase("graintec");
        this.collection = this.database.getCollection(collection);
        return this.collection;
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
