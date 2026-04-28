package com.wipro.JavaBasics.BankSystemException;

class BankAccount {
    private String name;
    private double balance;

    BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than 0");
        }
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than 0");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient Balance");
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    String getName() {
        return name;
    }
}