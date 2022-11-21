package com.example.gr3.p3.classes;

import org.bson.types.ObjectId;

public class Supplier{
    private ObjectId _id;
    private int pid;
    private String contactPerson;
    private String contactMail;
    private String supplier;
    private String supply;

    public Supplier(ObjectId _id, int pid, String contactPerson, String contactMail, String supplier, String supply) {
        this._id = _id;
        this.pid = pid;
        this.contactPerson = contactPerson;
        this.contactMail = contactMail;
        this.supplier = supplier;
        this.supply = supply;
    }

    public ObjectId get_id() {
        return _id;
    }

    public int getPid() {
        return pid;
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

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSupply() {
        return supply;
    }

    public void setSupply(String supply) {
        this.supply = supply;
    }
}