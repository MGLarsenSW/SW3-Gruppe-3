package com.example.gr3.p3.classes;

import java.util.Date;
import java.util.List;

public class Project {
    private int _id;
    private String projectName;
    private List<Supplier> supplierList;
    private Date deadlineDate;
    private Date QADate;

    public Project(int _id, String projectName, List<Supplier> supplierList, Date deadlineDate,
                   Date QADate) {
        this._id = _id;
        this.projectName = projectName;
        this.supplierList = supplierList;
        this.deadlineDate = deadlineDate;
        this.QADate = QADate;
    }

    public int get_id() {
        return _id;
    }

    public String getProjectName() {
        return projectName;
    }

    public List<Supplier> getSuppliers() {
        return supplierList;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public Date getQADate() {
        return QADate;
    }


}
