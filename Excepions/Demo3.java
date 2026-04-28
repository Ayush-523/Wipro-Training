package com.wipro.JavaBasics.Excepions;

public class Demo3 {
    public static void main(String[] args) {
        try {
            int age = 15;

            if (age < 18) {
                throw new MyException("Not eligible, age must be 18+");
            }

            System.out.println("Eligible");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}