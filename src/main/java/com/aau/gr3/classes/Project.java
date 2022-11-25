package com.aau.gr3.classes;

import java.util.Date;
import java.util.List;

public class Project {
    private int _id;
    private String projectName;
    private List<State> supplierList;
    private Date QADate;
    private Date quotationDate;
    private Date creationDate;
    private Date deadlineDate;


    public Project(){

    }
    public Project(int _id, String projectName, Date QADate, Date quotationDate,
                   Date creationDate, List<State> supplierList, Date deadlineDate) {
        this._id = _id;
        this.projectName = projectName;
        this.QADate = QADate;
        this.quotationDate = quotationDate;
        this.creationDate = creationDate;
        this.supplierList = supplierList;
        this.deadlineDate = deadlineDate;
    }
    public Project(int _id, String projectName, List<State> supplierList, Date deadlineDate, Date QADate) {
        this._id = _id;
        this.projectName = projectName;
        this.QADate = QADate;
        this.quotationDate = null;
        this.creationDate = null;
        this.supplierList = supplierList;
        this.deadlineDate = deadlineDate;
    }

    public int get_id() {
        return _id;
    }

    public String getProjectName() {
        return projectName;
    }

    public List<State> getSupplierList() {
        return supplierList;
    }

    public Date getQADate() {
        return QADate;
    }

    public Date getQuotationDate() {
        return quotationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

   /* public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public void setQADate(Date QADate) {
        this.QADate = QADate;
    }*/
}
