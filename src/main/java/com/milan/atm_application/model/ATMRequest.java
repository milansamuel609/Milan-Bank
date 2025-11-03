package com.milan.atm_application.model;

public class ATMRequest {
    private double amount;

    public ATMRequest() {}

    public ATMRequest(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
