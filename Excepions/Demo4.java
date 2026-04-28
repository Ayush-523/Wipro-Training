package com.wipro.JavaBasics.Excepions;

import java.util.Scanner;


public class Demo4{
    public static void divide(int a, int b) throws DivideByZeroException {
        if (b == 0) {
            throw new DivideByZeroException("Division by zero is not allowed.");
        }
        System.out.println("Result: " + (a / b));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers :");
        int a = sc.nextInt();
        int b = sc.nextInt();

        try {
            divide(a, b);
        } catch (DivideByZeroException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        sc.close();
    }
}