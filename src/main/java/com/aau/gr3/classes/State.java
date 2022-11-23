package com.aau.gr3.classes;

import org.bson.types.ObjectId;

public class State extends Supplier{
    private boolean RFI;
    private boolean tender;
    private boolean QA;
    private boolean reminder;
    private boolean quotation;
    private boolean contract;

    public State(ObjectId _id, int pid, String contactPerson, String contactMail,
                 String supplier, String supply, boolean RFI, boolean tender,
                 boolean QA, boolean reminder, boolean quotation, boolean contract){
        super(_id, pid, contactPerson, contactMail, supplier, supply);
        this.RFI = RFI;
        this.tender = tender;
        this.QA = QA;
        this.reminder = reminder;
        this.quotation = quotation;
        this.contract = contract;
    }
    public State(ObjectId _id, int pid, String contactPerson, String contactMail,
                 String supplier, String supply){
        super(_id, pid, contactPerson, contactMail, supplier, supply);
        this.RFI = false;
        this.tender = false;
        this.QA = false;
        this.reminder = false;
        this.quotation = false;
        this.contract = false;
    }

    public boolean isRFI() {
        return RFI;
    }

    public void setRFI(boolean RFI) {
        this.RFI = RFI;
    }

    public boolean isTender() {
        return tender;
    }

    public void setTender(boolean tender) {
        this.tender = tender;
    }

    public boolean isQA() {
        return QA;
    }

    public void setQA(boolean QA) {
        this.QA = QA;
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
}
