package com.wipro.JavaBasics.ArrayList;

import java.util.*;

public class EmployeeSalary {
    public static void main(String[] args) {
        ArrayList<Double> salaries = new ArrayList<>(Arrays.asList(1000.0, 2000.0, 3000.0));

        for (int i = 0; i < salaries.size(); i++) {
            salaries.set(i, salaries.get(i) * 1.10);
        }

        System.out.println(salaries);
    }
}