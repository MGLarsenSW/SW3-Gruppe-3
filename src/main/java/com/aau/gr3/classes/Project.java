package com.aau.gr3.classes;

import java.util.Date;

public class Project {
    protected int _id;
    protected String projectName;
    protected String supply;
    protected String supplier;
    protected String contactMail;
    protected String contactPerson;
    private Date deadlineDate;
    protected Date QADate;

    private boolean stateRFI;
    private boolean stateTender;
    private boolean stateQA;
    private boolean stateReminder;
    private boolean stateQuotation;
    private boolean stateContract;

    public Project(int _id, String projectName, String supply, String supplier, String contactMail, String contactPerson, Date deadlineDate,
                   Date QADate) {
        this._id = _id;
        this.projectName = projectName;
        this.supply = supply;
        this.supplier = supplier;
        this.contactMail = contactMail;
        this.contactPerson = contactPerson;
        this.deadlineDate = deadlineDate;
        this.QADate = QADate;
        this.stateRFI = false;
        this.stateTender = false;
        this.stateQA = false;
        this.stateReminder = false;
        this.stateQuotation = false;
        this.stateContract = false;
    }

    public int get_id() {
        return _id;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getSupply() {
        return supply;
    }

    public String getSupplier() {
        return supplier;
    }

    public String getContactMail() {
        return contactMail;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public Date getQADate() {
        return QADate;
    }

    public boolean isStateRFI() {
        return stateRFI;
    }

    public boolean isStateTender() {
        return stateTender;
    }

    public boolean isStateQA() {
        return stateQA;
    }

    public boolean isStateReminder() {
        return stateReminder;
    }

    public boolean isStateQuotation() {
        return stateQuotation;
    }

    public boolean isStateContract() {
        return stateContract;
    }

    public void setStateRFI(boolean stateRFI) {
        this.stateRFI = stateRFI;
    }

    public void setStateTender(boolean stateTender) {
        this.stateTender = stateTender;
    }

    public void setStateQA(boolean stateQA) {
        this.stateQA = stateQA;
    }

    public void setStateReminder(boolean stateReminder) {
        this.stateReminder = stateReminder;
    }

    public void setStateQuotation(boolean stateQuotation) {
        this.stateQuotation = stateQuotation;
    }

    public void setStateContract(boolean stateContract) {
        this.stateContract = stateContract;
    }
}
