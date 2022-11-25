package com.aau.gr3.util;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.io.BufferedReader;
import java.io.FileReader;

import static com.mongodb.MongoClient.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class Connection {
    protected MongoClient mongoClient;
    protected MongoDatabase database;

    public Connection() {
    }
    public void close(){
        try {
            this.mongoClient.close();
            System.out.println("Connection closed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void establish(){
        String directory = "src/main/resources/ProviderName";

        try {
            BufferedReader br = new BufferedReader(new FileReader(directory));
            String URI = br.readLine();
            br.close();

            CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

            this.mongoClient = new MongoClient(new MongoClientURI(URI));
            this.database = this.mongoClient.getDatabase("graintec").withCodecRegistry(pojoCodecRegistry);
            System.out.println("Connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
