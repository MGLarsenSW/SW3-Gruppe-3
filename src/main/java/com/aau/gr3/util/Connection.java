package com.aau.gr3.util;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

import static com.mongodb.MongoClient.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Component
public class Connection {
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static String URI;

    private Connection() {

    } // Keep this private so that it can't be instantiated outside this class

    /**
     * Gets the URI string from the application.properties
     * Implemented for deployment on Heroku
     * @param URI - URI string
     */
    @Value("${MONGODB_URI:#{null}}")
    public void setURI(String URI) {
        Connection.URI = URI;
    }

    /**
     * Establishes a connection to the database with a singleton pattern
     */
    public static void establish() {
        // Exit if the connection has already been established
        if (mongoClient != null){
            System.out.println("Connection already established");
            return;
        }

        // Create a connection to the database if it doesn't exist
        try {
            if (URI == null) {
                // Read the ProviderName file for database credentials
                String directory = "src/main/resources/ProviderName";
                BufferedReader br = new BufferedReader(new FileReader(directory));
                URI = br.readLine();
                br.close();
            }

            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            mongoClient = new MongoClient(new MongoClientURI(URI));
            database = mongoClient.getDatabase("graintec").withCodecRegistry(pojoCodecRegistry);
            System.out.println("Connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Close the connection to the database
     */
    public static void close(){
        if (mongoClient == null){
            System.out.println("Connection already closed");
            return;
        }

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
