package com.wipro.JavaBasics.Array;

import java.util.Scanner;

public class SumArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] my_array = new int[n];

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            my_array[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i : my_array) {
            sum += i;
        }

        System.out.println("The sum is " + sum);

        sc.close();
    }
}