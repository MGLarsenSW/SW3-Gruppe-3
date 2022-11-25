package com.aau.gr3.classes;

import org.bson.types.ObjectId;

// TODO: Add more relevant criteria from problem analysis
public class Scoring extends Supplier {
    private int guarantee;
    private boolean csr;
    private String siteErection;
    private int price; // 32-bit limitation???
    private boolean board;
    private boolean travel;
    private int score;
    public Scoring(ObjectId _id, int pid, String contactPerson, String contactMail,
                   String supplier, String supply, int guarantee, boolean csr, String siteErection, int price, boolean board, boolean travel, int score) {
        super(_id, pid, contactPerson, contactMail, supplier, supply);
        this.guarantee = guarantee;
        this.csr = csr;
        this.siteErection = siteErection;
        this.price = price;
        this.board = board;
        this.travel = travel;
        this.score = score;
    }
    public Scoring(ObjectId _id, int pid, String contactPerson, String contactMail,
                   String supplier, String supply) {
        super(_id, pid, contactPerson, contactMail, supplier, supply);
        this.guarantee = 0;
        this.csr = false;
        this.siteErection = "";
        this.price = 0;
        this.board = false;
        this.travel = false;
        this.score = 0;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    public boolean isCsr() {
        return csr;
    }

    public void setCsr(boolean csr) {
        this.csr = csr;
    }

    public String getSiteErection() {
        return siteErection;
    }

    public void setSiteErection(String siteErection) {
        this.siteErection = siteErection;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBoard() {
        return board;
    }

    public void setBoard(boolean board) {
        this.board = board;
    }

    public boolean isTravel() {
        return travel;
    }

    public void setTravel(boolean travel) {
        this.travel = travel;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
