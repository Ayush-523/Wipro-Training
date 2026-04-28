package com.wipro.JavaBasics.BankSystemException;

import java.util.Scanner;

public class BankAccountMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        BankAccount acc = new BankAccount(name, bal);

        int choice;

        do {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter amount: ");
                        double d = sc.nextDouble();
                        acc.deposit(d);
                        break;

                    case 2:
                        System.out.print("Enter amount: ");
                        double w = sc.nextDouble();
                        acc.withdraw(w);
                        break;

                    case 3:
                        acc.checkBalance();
                        break;

                    case 4:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (InvalidAmountException | InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 4);

        sc.close();
    }
}