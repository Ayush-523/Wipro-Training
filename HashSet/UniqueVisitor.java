package com.wipro.JavaBasics.HashSet;

import java.util.*;

public class UniqueVisitor {
    public static void main(String[] args) {
        HashSet<String> visitors = new HashSet<>(Arrays.asList("User1", "User2", "User1", "User3"));

        System.out.println("Unique Visitors: " + visitors.size());
    }
}