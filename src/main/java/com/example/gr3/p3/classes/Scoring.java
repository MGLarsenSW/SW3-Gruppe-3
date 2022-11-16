package com.example.gr3.p3.classes;

// TODO: Add more relevant criteria from
public class Scoring {
    private int guarantee;
    private boolean csr;
    private String siteErection;
    private int price; // 64-bit limitation???
    private boolean board;
    private boolean travel;

    public Scoring() {
        this.guarantee = 0;
        this.csr = false;
        this.siteErection = null;
        this.price = 0;
        this.board = false;
        this.travel = false;
    }
}
