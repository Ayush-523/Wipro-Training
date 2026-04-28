package com.wipro.JavaBasics.Abstraction;

//Import Scanner
import java.util.Scanner;

//Abstract class
abstract class Employee {
 String name;
 double salary;

 Employee(String name, double salary) {
     this.name = name;
     this.salary = salary;
 }

 abstract double calculateBonus();
}

//Manager class
class Manager extends Employee {
 Manager(String name, double salary) {
     super(name, salary);
 }

 double calculateBonus() {
     return 0.2 * salary;
 }
}

//Developer class
class Developer extends Employee {
 Developer(String name, double salary) {
     super(name, salary);
 }

 double calculateBonus() {
     return 0.1 * salary;
 }
}

//Main class
public class EmployeeDetails {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     // Input for Manager
     System.out.print("Enter Manager Name: ");
     String mName = sc.nextLine();
     System.out.print("Enter Manager Salary: ");
     double mSalary = sc.nextDouble();
     sc.nextLine(); // clear buffer

     // Input for Developer
     System.out.print("Enter Developer Name: ");
     String dName = sc.nextLine();
     System.out.print("Enter Developer Salary: ");
     double dSalary = sc.nextDouble();

     // Create objects
     Employee e1 = new Manager(mName, mSalary);
     Employee e2 = new Developer(dName, dSalary);

     // Output
     System.out.println(e1.name + " Bonus: " + e1.calculateBonus());
     System.out.println(e2.name + " Bonus: " + e2.calculateBonus());

     sc.close();
 }
}