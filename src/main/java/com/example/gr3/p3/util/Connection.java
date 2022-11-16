package com.example.gr3.p3.util;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Connection {
    private MongoClientURI connectionString = new MongoClientURI("<insert URI>");
    private MongoClient mongoClient;
    public MongoDatabase database;
    public MongoCollection<Document> collection;

    // Constructor: Connection("graintec", "Project");
    public Connection(String database, String collection) {
        this.mongoClient = new MongoClient(connectionString);
        this.database = mongoClient.getDatabase(database);
        this.collection = this.database.getCollection(collection);
    }

    public MongoClient establish(){
        System.out.println("Connection established");
        return mongoClient;
    }
    public void close(){
        this.mongoClient.close();
        System.out.println("Connection closed");
    }
}
