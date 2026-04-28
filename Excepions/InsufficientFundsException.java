package com.wipro.JavaBasics.Excepions;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException() {
        super("Insufficient funds to withdraw");
    }
    
    public InsufficientFundsException(double amount) {
        super("Insufficient funds to withdraw " + amount);
    }
}