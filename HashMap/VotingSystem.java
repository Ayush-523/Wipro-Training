package com.wipro.JavaBasics.HashMap;

import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {
        HashMap<String, Integer> votes = new HashMap<>();

        String[] input = {"A", "B", "A", "C", "A", "B"};

        for (String v : input) {
            votes.put(v, votes.getOrDefault(v, 0) + 1);
        }

        String winner = "";
        int max = 0;

        for (Map.Entry<String, Integer> e : votes.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                winner = e.getKey();
            }
        }

        System.out.println("Winner: " + winner + " Votes: " + max);
    }
}