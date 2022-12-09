package com.aau.gr3.crud;

import com.mongodb.client.MongoDatabase;

public abstract class Crud {
    protected MongoDatabase mongoDatabase;

    public Crud(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }
}
