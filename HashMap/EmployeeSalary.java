package com.wipro.JavaBasics.HashMap;

import java.util.*;

public class EmployeeSalary {
    public static void main(String[] args) {
        HashMap<Integer, Double> map = new HashMap<>();

        map.put(101, 50000.0);
        map.put(102, 60000.0);

        int id = 102;

        System.out.println(map.getOrDefault(id, -1.0));
    }
}