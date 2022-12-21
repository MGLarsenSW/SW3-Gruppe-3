package com.aau.gr3.classes;

// TODO: Add more relevant criteria from problem analysis
public class Scoring {
    private String tc;
    private int guarantee;
    private boolean csr;
    private String siteErection;
    private int price; // 32-bit limitation? Consider using long instead
    private boolean board;
    private boolean travel;
    private int score;

    public Scoring() {
        this.guarantee = 0;
        this.csr = false;
        this.tc = "";
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

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }
}
