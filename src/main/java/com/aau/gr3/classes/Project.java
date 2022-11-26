package com.aau.gr3.classes;

import java.util.Date;

public class Project {
    private int id;
    private String projectName;
    private String qaDate;
    private String quotationDate;
    private String creationDate;
    private String deadlineDate;

    public Project() {

    } // Empty constructor for POJO codec

    public Project(int id, String projectName, String qaDate, String quotationDate, String creationDate, String deadlineDate) {
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

    public String getQaDate() {
        return qaDate;
    }

    public void setQaDate(String qaDate) {
        this.qaDate = qaDate;
    }

    public String getQuotationDate() {
        return quotationDate;
    }

    public void setQuotationDate(String quotationDate) {
        this.quotationDate = quotationDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }
}
