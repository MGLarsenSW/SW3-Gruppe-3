package com.aau.gr3.classes;

public class State{
    private boolean rfi;
    private boolean scoring;
    private boolean tender;
    private boolean qa;
    private boolean reminder;
    private boolean contract;
    private int percentage;

    public State() {
        this.rfi = false;
        this.scoring = false;
        this.tender = false;
        this.qa = false;
        this.reminder = false;
        this.contract = false;
    }

    public boolean isRfi() {
        return rfi;
    }

    public void setRfi(boolean rfi) {
        this.rfi = rfi;
    }

    public boolean isTender() {
        return tender;
    }

    public void setTender(boolean tender) {
        this.tender = tender;
    }

    public boolean isQa() {
        return qa;
    }

    public void setQa(boolean qa) {
        this.qa = qa;
    }

    public boolean isReminder() {
        return reminder;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }

    public boolean isScoring() {
        return scoring;
    }

    public void setScoring(boolean scoring) {
        this.scoring = scoring;
    }

    public boolean isContract() {
        return contract;
    }

    public void setContract(boolean contract) {
        this.contract = contract;
    }

    public int getPercentage() {
        return percentage;
    }

    // TODO: Refactor this method to be more prettier?
    public void calculatePercentage() {
        int percentage = 0;

        if (this.rfi) {
            percentage += 20;
        }
        if (this.tender) {
            percentage += 20;
        }
        if (this.qa) {
            percentage += 20;
        }
        if (this.reminder) {
            percentage += 20;
        }
        if (this.scoring) {
            percentage += 20;
        }
        this.percentage = percentage;
    }
}
