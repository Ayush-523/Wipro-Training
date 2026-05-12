package com.example.springhiborm;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.springhiborm.entity.Student;
import com.example.springhiborm.service.StudentService;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentService service = context.getBean(StudentService.class);
        Scanner sc = new Scanner(System.in);
        Student student = new Student();

        System.out.println("Enter Student ID:");
        student.setId(sc.nextInt());
        sc.nextLine();

        System.out.println("Enter Student Name:");
        student.setName(sc.nextLine());

        System.out.println("Enter Course:");
        student.setCourse(sc.nextLine());

        System.out.println("Enter Email:");
        student.setEmail(sc.nextLine());

        service.saveStudent(student);

        System.out.println("Student saved successfully!");

        sc.close();
    }
}