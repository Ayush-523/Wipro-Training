package com.wipro.JavaBasics.Array;

import java.util.Scanner;

public class CopyArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] my_array = new int[n];
        int[] new_array = new int[n];

        for (int i = 0; i < n; i++) {
            my_array[i] = sc.nextInt();
        }

        System.out.print("Source Array : [");
        for (int i = 0; i < n; i++) {
            System.out.print(my_array[i]);
            if (i < n - 1) System.out.print(", ");
        }
        System.out.println("]");

        for (int i = 0; i < n; i++) {
            new_array[i] = my_array[i];
        }

        System.out.print("New Array: [");
        for (int i = 0; i < n; i++) {
            System.out.print(new_array[i]);
            if (i < n - 1) System.out.print(", ");
        }
        System.out.println("]");

        sc.close();
    }
}