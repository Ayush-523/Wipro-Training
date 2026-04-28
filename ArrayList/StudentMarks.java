package com.wipro.JavaBasics.ArrayList;

import java.util.*;

public class StudentMarks {
    public static void main(String[] args) {
        ArrayList<Integer> marks = new ArrayList<>(Arrays.asList(80, 90, 70, 60, 85));

        int max = Collections.max(marks);
        int min = Collections.min(marks);

        int sum = 0;
        for (int m : marks) sum += m;

        double avg = (double) sum / marks.size();

        System.out.println("Highest: " + max);
        System.out.println("Lowest: " + min);
        System.out.println("Average: " + avg);
    }
}