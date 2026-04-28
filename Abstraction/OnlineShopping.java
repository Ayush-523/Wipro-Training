package com.wipro.JavaBasics.Abstraction;

import java.util.Scanner;

abstract class Product {
 double price;

 Product(double price) {
     this.price = price;
 }

 abstract double getPrice();
}

interface Discount {
 double applyDiscount();
}

class Electronics extends Product implements Discount {

 Electronics(double price) {
     super(price);
 }

 double getPrice() {
     return price;
 }

 public double applyDiscount() {
     return price - (0.10 * price); 
 }
}

class Clothing extends Product implements Discount {

 Clothing(double price) {
     super(price);
 }

 double getPrice() {
     return price;
 }

 public double applyDiscount() {
     return price - (0.20 * price); 
 }
}

public class OnlineShopping {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     System.out.println("Choose Product Type:");
     System.out.println("1. Electronics");
     System.out.println("2. Clothing");

     int choice = sc.nextInt();

     System.out.print("Enter price: ");
     double price = sc.nextDouble();

     Product p;
     Discount d;

     switch (choice) {
         case 1:
             p = new Electronics(price);
             d = (Electronics) p;
             break;
         case 2:
             p = new Clothing(price);
             d = (Clothing) p;
             break;
         default:
             System.out.println("Invalid choice!");
             sc.close();
             return;
     }

     System.out.println("Original Price: " + p.getPrice());
     System.out.println("Price after Discount: " + d.applyDiscount());

     sc.close();
 }
}