package com.milan.atm_application.model;

public class ATMResponse {
    private boolean success;
    private String message;
    private double balance;

    public ATMResponse() {
    }

    public ATMResponse(boolean success, String message, double balance) {
        this.success = success;
        this.message = message;
        this.balance = balance;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}