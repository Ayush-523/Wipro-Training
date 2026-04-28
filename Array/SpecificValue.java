package com.wipro.JavaBasics.Array;

import java.util.Scanner;

public class SpecificValue {
    public static boolean contains(int[] arr, int item) {
        for (int n : arr) {
            if (item == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] my_array1 = new int[n];

        for (int i = 0; i < n; i++) {
            my_array1[i] = sc.nextInt();
        }

        int item1 = sc.nextInt();
        int item2 = sc.nextInt();

        System.out.println(contains(my_array1, item1));
        System.out.println(contains(my_array1, item2));

        sc.close();
    }
}