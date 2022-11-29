package com.aau.gr3.classes;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Supplier{
    private ObjectId id;
    private int pid;
    private String contactPerson;
    private String contactMail;
    private String supplierName;
    private String supply;
    @BsonProperty(value = "State")
    private State state;
    @BsonProperty(value = "Scoring")
    private Scoring scoring;

    public Supplier() {} // Empty constructor for POJO codec

    public Supplier(ObjectId id, int pid, String contactPerson, String contactMail, String supplierName, String supply, State state, Scoring scoring) {
        this.id = id;
        this.pid = pid;
        this.contactPerson = contactPerson;
        this.contactMail = contactMail;
        this.supplierName = supplierName;
        this.supply = supply;
        this.state = state;
        this.scoring = scoring;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupply() {
        return supply;
    }

    public void setSupply(String supply) {
        this.supply = supply;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Scoring getScoring() {
        return scoring;
    }

    public void setScoring(Scoring scoring) {
        this.scoring = scoring;
    }
}