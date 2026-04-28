package com.wipro.JavaBasics.HashSet;

import java.util.*;

public class LotterySystem {
    public static void main(String[] args) {
        HashSet<Integer> tickets = new HashSet<>();

        int[] input = {101, 102, 101, 103};

        for (int t : input) {
            if (tickets.add(t))
                System.out.println("Accepted: " + t);
            else
                System.out.println("Rejected: " + t);
        }
    }
}