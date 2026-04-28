package com.wipro.JavaBasics.Array;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in numeric array: ");
        int n = sc.nextInt();
        int[] my_array1 = new int[n];

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            my_array1[i] = sc.nextInt();
        }

        System.out.print("Enter number of elements in string array: ");
        int m = sc.nextInt();
        sc.nextLine(); 
        String[] my_array2 = new String[m];

        System.out.println("Enter " + m + " strings:");
        for (int i = 0; i < m; i++) {
            my_array2[i] = sc.nextLine();
        }

        System.out.println("Original numeric array : " + Arrays.toString(my_array1));
        System.out.println("Original string array : " + Arrays.toString(my_array2));

        Arrays.sort(my_array1);
        Arrays.sort(my_array2);

        System.out.println("Sorted numeric array : " + Arrays.toString(my_array1));
        System.out.println("Sorted string array : " + Arrays.toString(my_array2));

        sc.close();
    }
}