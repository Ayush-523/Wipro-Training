package com.example;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.ReportCard;
import com.example.model.Student;
import com.example.util.HibernateUtil;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking Student Input
        System.out.println("Enter Student Name:");
        String name = sc.nextLine();

        System.out.println("Enter Course Name:");
        String course = sc.nextLine();

        // Taking ReportCard Input
        System.out.println("Enter Marks:");
        int marks = sc.nextInt();

        sc.nextLine();

        System.out.println("Enter Grade:");
        String grade = sc.nextLine();

        // Creating Objects
        ReportCard rc = new ReportCard(marks, grade);

        Student student = new Student(name, course, rc);

        // Hibernate Code
        Session session = HibernateUtil
                .getSessionFactory()
                .openSession();

        Transaction tx = session.beginTransaction();

        // Save Object
        session.persist(student);

        tx.commit();

        // Displaying Data in Console
        System.out.println("\n===== DATA INSERTED =====");

        System.out.println("Student Id : " + student.getId());
        System.out.println("Student Name : " + student.getName());
        System.out.println("Course : " + student.getCourse());

        System.out.println("ReportCard Id : " + rc.getId());
        System.out.println("Marks : " + rc.getMarks());
        System.out.println("Grade : " + rc.getGrade());

        session.close();
        sc.close();

        System.out.println("\nData Inserted Successfully Into Database");
    }
}