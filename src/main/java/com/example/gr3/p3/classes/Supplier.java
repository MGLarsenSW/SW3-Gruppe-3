package com.example.gr3.p3.classes;

import org.bson.types.ObjectId;

public class Supplier {
    private ObjectId _id;
    private int pid;
    private String contactPerson;
    private String contactMail;
    private String supplier;
    private String supply;
    private boolean stateRFI;
    private boolean stateTender;
    private boolean stateQA;
    private boolean stateReminder;
    private boolean stateQuotation;
    private boolean stateContract;

    public Supplier(ObjectId _id, int pid, String contactPerson, String contactMail,
                    String supplier, String supply, boolean stateRFI, boolean stateTender,
                    boolean stateQA, boolean stateReminder, boolean stateQuotation, boolean stateContract) {
        this._id = _id;
        this.pid = pid;
        this.contactPerson = contactPerson;
        this.contactMail = contactMail;
        this.supplier = supplier;
        this.supply = supply;
        this.stateRFI = stateRFI;
        this.stateTender = stateTender;
        this.stateQA = stateQA;
        this.stateReminder = stateReminder;
        this.stateQuotation = stateQuotation;
        this.stateContract = stateContract;
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

    public boolean isStateRFI() {
        return stateRFI;
    }

    public void setStateRFI(boolean stateRFI) {
        this.stateRFI = stateRFI;
    }

    public boolean isStateTender() {
        return stateTender;
    }

    public void setStateTender(boolean stateTender) {
        this.stateTender = stateTender;
    }

    public boolean isStateQA() {
        return stateQA;
    }

    public void setStateQA(boolean stateQA) {
        this.stateQA = stateQA;
    }

    public boolean isStateReminder() {
        return stateReminder;
    }

    public void setStateReminder(boolean stateReminder) {
        this.stateReminder = stateReminder;
    }

    public boolean isStateQuotation() {
        return stateQuotation;
    }

    public void setStateQuotation(boolean stateQuotation) {
        this.stateQuotation = stateQuotation;
    }

    public boolean isStateContract() {
        return stateContract;
    }

    public void setStateContract(boolean stateContract) {
        this.stateContract = stateContract;
    }
}