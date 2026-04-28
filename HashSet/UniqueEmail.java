package com.wipro.JavaBasics.HashSet;

import java.util.*;

public class UniqueEmail {
    public static void main(String[] args) {
        HashSet<String> emails = new HashSet<>();

        String[] input = {"a@gmail.com", "b@gmail.com", "a@gmail.com"};

        for (String email : input) {
            if (emails.add(email))
                System.out.println("Registered: " + email);
            else
                System.out.println("Duplicate: " + email);
        }
    }
}