package com.wipro.JavaBasics.Methods;

class BankAccount {
    String accountHolder;
    double balance;

    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    void displayDetails() {
        System.out.println("Account Holder: " + accountHolder);
        checkBalance();
    }
}

public class BankAccountDetails {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Rahul", 1000);
        BankAccount acc2 = new BankAccount("Priya", 2000);

        acc1.deposit(500);
        acc1.withdraw(300);
        acc1.checkBalance();

        System.out.println();

        acc2.deposit(1000);
        acc2.withdraw(2500);
        acc2.checkBalance();

        System.out.println();

        acc1.displayDetails();
        acc2.displayDetails();
    }
}