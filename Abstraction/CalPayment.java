package com.wipro.JavaBasics.Abstraction;

import java.util.Scanner;

interface Payment {
 void pay(double amount);
}

class CreditCard implements Payment {
 public void pay(double amount) {
     System.out.println("Paid " + amount + " using Credit Card");
 }
}

class UPI implements Payment {
 public void pay(double amount) {
     System.out.println("Paid " + amount + " using UPI");
 }
}

class Cash implements Payment {
 public void pay(double amount) {
     System.out.println("Paid " + amount + " using Cash");
 }
}

public class CalPayment {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     System.out.println("Choose Payment Method:");
     System.out.println("1. Credit Card");
     System.out.println("2. UPI");
     System.out.println("3. Cash");

     int choice = sc.nextInt();

     System.out.print("Enter amount: ");
     double amount = sc.nextDouble();

     Payment p;

     switch (choice) {
         case 1:
             p = new CreditCard();
             break;
         case 2:
             p = new UPI();
             break;
         case 3:
             p = new Cash();
             break;
         default:
             System.out.println("Invalid choice!");
             sc.close();
             return;
     }

     p.pay(amount);

     sc.close();
 }
}