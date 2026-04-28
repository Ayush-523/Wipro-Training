package com.wipro.JavaBasics.Array;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array ");
        int n = sc.nextInt();
        int[] my_array = new int[n];

        for (int i = 0; i < n; i++) {
            my_array[i] = sc.nextInt();
        }

        System.out.println("Original Array : " + Arrays.toString(my_array));

        int removeIndex = sc.nextInt();

        for (int i = removeIndex; i < my_array.length - 1; i++) {
            my_array[i] = my_array[i + 1];
        }

        int[] newArray = Arrays.copyOf(my_array, my_array.length - 1);

        System.out.println("After removing the element: " + Arrays.toString(newArray));

        sc.close();
    }
}