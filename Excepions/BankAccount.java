package com.wipro.JavaBasics.Excepions;

class BankAccount {

    private String fullName;
    private double balance;

    public BankAccount(String fullName, double balance) {
        this.fullName = fullName;
        this.balance = balance;
    }

    public void withdrawFunds(double amount) {
        this.balance -= amount;
    }
    public void withdrawFunds1(double amount) throws InsufficientFundsException {

        if(amount>balance){
            throw new InsufficientFundsException(amount);
        }
        this.balance -= amount;
    }
    public String getFullName() {
        return fullName;
    }

    public double getBalance() {
        return balance;
    }
}