package com.wipro.JavaBasics.GenericDataType;

import java.util.ArrayList;
import java.util.List;

public class Demo9 {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        Student s1 = new Student("Sakshi", 12);
        Student s2 = new Student("Ram", 22);
        Student s3 = new Student("Sakshi", 12);
        Student s4 = new Student("Sneha", 14);

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        students.parallelStream()
                .filter(x -> x.getName().contains("S"))
                .map(x -> x.getName().toLowerCase())
                .sorted()
                .forEach(x -> System.out.println(x));
    }
}