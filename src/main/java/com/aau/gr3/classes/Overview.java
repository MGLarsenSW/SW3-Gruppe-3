package com.aau.gr3.classes;

import java.awt.*;
import java.util.Date;

public class Overview {
    private int _id;
    private String projectName;
    private Date creationDate;
    private Date deadlineDate;
    //private Image image;

    public Overview(int _id, String projectName, Date creationDate, Date deadlineDate, Image image) {
        this._id = _id;
        this.projectName = projectName;
        this.creationDate = creationDate;
        this.deadlineDate = deadlineDate;
        //this.image = image;
    }

    public Overview(int _id, String projectName, Date creationDate, Date deadlineDate) {
        this._id = _id;
        this.projectName = projectName;
        this.creationDate = creationDate;
        this.deadlineDate = deadlineDate;
        //this.image = null;
    }
    public Overview() {}

    public int get_id() {
        return _id;
    }

    public String getProjectName() {
        return projectName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }
}

