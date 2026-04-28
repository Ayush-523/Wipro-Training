package com.wipro.JavaBasics.Array;

import java.util.Scanner;

public class Grid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] a = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%2d ", a[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}