package com.wipro.JavaBasics.HashMap;

import java.util.*;

public class StudentDatabase {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "Sakshi");
        map.put(2, "Mohit");

        int id = 1;

        System.out.println(map.getOrDefault(id, "Not Found"));
    }
}