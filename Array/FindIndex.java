package com.wipro.JavaBasics.Array;

import java.util.Scanner;

public class FindIndex {
    public static int findIndex(int[] arr, int t) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == t) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] my_array = new int[n];

        for (int i = 0; i < n; i++) {
            my_array[i] = sc.nextInt();
        }

        int t1 = sc.nextInt();
        int t2 = sc.nextInt();
        int t3 = sc.nextInt();

        int index1 = findIndex(my_array, t1);
        int index2 = findIndex(my_array, t2);
        int index3 = findIndex(my_array, t3);

        if (index1 != -1)
            System.out.println("Index position of " + t1 + " is: " + index1);

        if (index2 != -1)
            System.out.println("Index position of " + t2 + " is: " + index2);

        if (index3 != -1)
            System.out.println("Index position of " + t3 + " is: " + index3);

        sc.close();
    }
}