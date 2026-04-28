package com.wipro.JavaBasics.Abstraction;

import java.util.Scanner;

public class BankingProg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double balance = 0;
        int choice;

        do {
            System.out.println("Enter your choice ...");
            System.out.println("1. Credit (Deposit)");
            System.out.println("2. Debit (Withdraw)");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double deposit = sc.nextDouble();
                    balance += deposit;
                    System.out.println("Deposited: " + deposit);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();
                    if (withdraw > balance) {
                        System.out.println("Insufficient balance!");
                    } else {
                        balance -= withdraw;
                        System.out.println("Debited: " + withdraw);
                    }
                    break;

                case 3:
                    System.out.println("Current Balance: " + balance);
                    break;

                case 4:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}