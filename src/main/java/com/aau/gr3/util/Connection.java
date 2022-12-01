package com.aau.gr3.util;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.io.BufferedReader;
import java.io.FileReader;

import static com.mongodb.MongoClient.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Connection {
    private static MongoClient mongoClient;
    private static MongoDatabase database;

    private Connection() {

    } // Keep this private so that it can't be instantiated

    /**
     * Establishes a connection to the database with a singleton pattern
     */
    public static void establish(){
        String directory = "src/main/resources/ProviderName";

        // Create a connection to the database if it doesn't exist
        if (mongoClient == null){
            try {
                // Read the ProviderName file for database credentials
                BufferedReader br = new BufferedReader(new FileReader(directory));
                String URI = br.readLine();
                br.close();

                CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
                CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

                mongoClient = new MongoClient(new MongoClientURI(URI));
                database = mongoClient.getDatabase("graintec").withCodecRegistry(pojoCodecRegistry);
                System.out.println("Connection established");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Connection already established");
        }
    }

    /**
     * Close the connection to the database
     */
    public static void close(){
        try {
            mongoClient.close();
            System.out.println("Connection closed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the database instance
     * @return - Returns the database instance
     */
    public static MongoDatabase getInstance() {
        return database;
    }
}
