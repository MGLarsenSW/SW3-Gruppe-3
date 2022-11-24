package com.aau.gr3.classes;

import org.bson.types.ObjectId;

public class State extends Supplier{
    private boolean stateRFI;
    private boolean stateTender;
    private boolean stateQA;
    private boolean stateReminder;
    private boolean stateQuotation;
    private boolean stateContract;

    public State(ObjectId _id, int pid, String contactPerson, String contactMail,
                 String supplier, String supply, boolean stateRFI, boolean stateTender,
                 boolean stateQA, boolean stateReminder, boolean stateQuotation, boolean stateContract){
        super(_id, pid, contactPerson, contactMail, supplier, supply);
        this.stateRFI = stateRFI;
        this.stateTender = stateTender;
        this.stateQA = stateQA;
        this.stateReminder = stateReminder;
        this.stateQuotation = stateQuotation;
        this.stateContract = stateContract;
    }

    public boolean isStateRFI() {
        return stateRFI;
    }

    public void setStateRFI(boolean stateRFI) {
        this.stateRFI = stateRFI;
    }

    public boolean isStateTender() {
        return stateTender;
    }

    public void setStateTender(boolean stateTender) {
        this.stateTender = stateTender;
    }

    public boolean isStateQA() {
        return stateQA;
    }

    public void setStateQA(boolean stateQA) {
        this.stateQA = stateQA;
    }

    public boolean isStateReminder() {
        return stateReminder;
    }

    public void setStateReminder(boolean stateReminder) {
        this.stateReminder = stateReminder;
    }

    public boolean isStateQuotation() {
        return stateQuotation;
    }

    public void setStateQuotation(boolean stateQuotation) {
        this.stateQuotation = stateQuotation;
    }

    public boolean isStateContract() {
        return stateContract;
    }

    public void setStateContract(boolean stateContract) {
        this.stateContract = stateContract;
    }
}
