package com.wipro.JavaBasics.Methods;

class Employee {
    String name;
    double basicSalary;

    // Constructor
    Employee(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
    }

    // Calculate HRA (20%)
    double calculateHRA() {
        return 0.20 * basicSalary;
    }

    // Calculate DA (10%)
    double calculateDA() {
        return 0.10 * basicSalary;
    }

    // Calculate Total Salary
    double calculateTotalSalary() {
        return basicSalary + calculateHRA() + calculateDA();
    }

    // Display salary breakdown
    void displaySalaryDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("HRA (20%): " + calculateHRA());
        System.out.println("DA (10%): " + calculateDA());
        System.out.println("Total Salary: " + calculateTotalSalary());
        System.out.println("---------------------------");
    }
}

public class EmployeeDetails {
    public static void main(String[] args) {
        // Create employee objects
        Employee e1 = new Employee("Rahul", 30000);
        Employee e2 = new Employee("Priya", 45000);

        // Display salary details
        e1.displaySalaryDetails();
        e2.displaySalaryDetails();
    }
}