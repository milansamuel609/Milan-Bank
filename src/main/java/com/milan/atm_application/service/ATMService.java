package com.milan.atm_application.service;

import com.milan.atm_application.model.UserAccount;
import com.milan.atm_application.model.ATMResponse;
import org.springframework.stereotype.Service;

@Service
public class ATMService {
    private UserAccount account = new UserAccount(0);
    private boolean initialized = false;

    public ATMResponse initialize(double amount) {
        if (initialized) {
            return new ATMResponse(false, "Account already initialized", account.getBalance());
        }
        if (amount < 100) {
            return new ATMResponse(false, "Initial balance must be ₹100 or greater", 0);
        }
        account = new UserAccount(amount);
        initialized = true;
        return new ATMResponse(true, "Account initialized successfully", account.getBalance());
    }

    public ATMResponse deposit(double amount) {
        if (!initialized) {
            return new ATMResponse(false, "Please initialize account first", 0);
        }
        if (account.deposit(amount)) {
            return new ATMResponse(true, "Deposit successful", account.getBalance());
        }
        return new ATMResponse(false, "Invalid amount", account.getBalance());
    }

    public ATMResponse withdraw(double amount) {
        if (!initialized) {
            return new ATMResponse(false, "Please initialize account first", 0);
        }
        if (amount <= 0) {
            return new ATMResponse(false, "Invalid amount", account.getBalance());
        }
        if (account.getBalance() - amount < 100) {
            return new ATMResponse(false, "Insufficient funds - Minimum balance of ₹100 must be maintained", account.getBalance());
        }
        if (account.withdraw(amount)) {
            return new ATMResponse(true, "Withdrawal successful", account.getBalance());
        }
        return new ATMResponse(false, "Insufficient funds or invalid amount", account.getBalance());
    }

    public ATMResponse getBalance() {
        if (!initialized) {
            return new ATMResponse(false, "Please initialize account first", 0);
        }
        return new ATMResponse(true, "Balance retrieved", account.getBalance());
    }

    public ATMResponse checkStatus() {
        return new ATMResponse(true, initialized ? "initialized" : "not_initialized",
                initialized ? account.getBalance() : 0);
    }
}
