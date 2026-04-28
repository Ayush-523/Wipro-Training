package com.wipro.JavaBasics.Excepions;

import java.util.Scanner;

public class Demo5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        double balance = sc.nextDouble();
        double withdraw = sc.nextDouble();

        BankAccount acc1 = new BankAccount(name, balance);
        acc1.withdrawFunds(withdraw);

        System.out.println("BALANCE FOR " + acc1.getFullName()
                + "'s ACCOUNT IS " + acc1.getBalance() + " USD");

        sc.close();
    }
}