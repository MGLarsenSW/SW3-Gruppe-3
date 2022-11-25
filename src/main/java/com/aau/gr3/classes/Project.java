package com.aau.gr3.classes;

import java.util.Date;

public class Project {
    private int id;
    private String projectName;
    private Date qaDate;
    private Date quotationDate;
    private Date creationDate;
    private Date deadlineDate;

    public Project() {

    } // Empty constructor for POJO codec

    public Project(int id, String projectName, Date qaDate, Date quotationDate, Date creationDate, Date deadlineDate) {
        this.id = id;
        this.projectName = projectName;
        this.qaDate = qaDate;
        this.quotationDate = quotationDate;
        this.creationDate = creationDate;
        this.deadlineDate = deadlineDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getQaDate() {
        return qaDate;
    }

    public void setQaDate(Date qaDate) {
        this.qaDate = qaDate;
    }

    public Date getQuotationDate() {
        return quotationDate;
    }

    public void setQuotationDate(Date quotationDate) {
        this.quotationDate = quotationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }
}
