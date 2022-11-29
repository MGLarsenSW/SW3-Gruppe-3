package com.aau.gr3.classes;

public class State{
    private boolean rfi;
    private boolean tender;
    private boolean qa;
    private boolean reminder;
    private boolean quotation;
    private boolean contract;
    private int percentage;

    public State() {
        this.rfi = false;
        this.tender = false;
        this.qa = false;
        this.reminder = false;
        this.quotation = false;
        this.contract = false;
        this.percentage = 0;
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

    public boolean isQuotation() {
        return quotation;
    }

    public void setQuotation(boolean quotation) {
        this.quotation = quotation;
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

    public void setPercentage() {
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
        if (this.quotation) {
            percentage += 20;
        }
        this.percentage = percentage;
    }
}
