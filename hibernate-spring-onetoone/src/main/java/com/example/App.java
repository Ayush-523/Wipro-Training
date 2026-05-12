package com.example;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.model.ReportCard;
import com.example.model.Student;
import com.example.service.StudentService;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(
                        AppConfig.class);

        StudentService service =
                context.getBean(StudentService.class);

        Scanner sc = new Scanner(System.in);

        // Input Student
        System.out.println("Enter Student Name:");
        String name = sc.nextLine();

        System.out.println("Enter Course:");
        String course = sc.nextLine();

        // Input ReportCard
        System.out.println("Enter Marks:");
        int marks = sc.nextInt();

        sc.nextLine();

        System.out.println("Enter Grade:");
        String grade = sc.nextLine();

        // Create ReportCard
        ReportCard rc = new ReportCard();

        rc.setMarks(marks);
        rc.setGrade(grade);

        // Create Student
        Student student = new Student();

        student.setName(name);
        student.setCourse(course);

        // Setter Injection
        student.setReportCard(rc);

        // Save
        service.addStudent(student);

        System.out.println("\n===== DATA SAVED =====");

        System.out.println("Student Name : "
                + student.getName());

        System.out.println("Course : "
                + student.getCourse());

        System.out.println("Marks : "
                + rc.getMarks());

        System.out.println("Grade : "
                + rc.getGrade());

        sc.close();
    }
}