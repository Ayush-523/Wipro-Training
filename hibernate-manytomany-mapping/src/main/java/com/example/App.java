package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.model.Course;
import com.example.model.Student;
import com.example.util.HibernateUtil;

public class App {

    public static void main(String[] args) {

        // OPEN SESSION
        Session session =
                HibernateUtil
                        .getSessionFactory()
                        .openSession();

        // BEGIN TRANSACTION
        Transaction tx = session.beginTransaction();

        // CREATE COURSES
        Course c1 = new Course("Operating System");
        Course c2 = new Course("Microprocessor");

        // CREATE STUDENTS
        Student ritu = new Student("Ritu");
        Student sakshi = new Student("Sakshi");
        Student shubham = new Student("Shubham");

        // ADD COURSES TO STUDENTS
        ritu.addCourse(c1);
        ritu.addCourse(c2);

        sakshi.addCourse(c1);

        shubham.addCourse(c2);

        // SAVE DATA
        session.persist(ritu);
        session.persist(sakshi);
        session.persist(shubham);

        // COMMIT
        tx.commit();

        // FETCH COURSE
        Course course =
                session.get(Course.class, 1L);

        // DISPLAY
        System.out.println(
                "Course Details : "
                        + course.getTitle());

        course.getStudents().forEach(
                st -> System.out.println(
                        "These Students are enrolled : "
                                + st.getName()));

        // CLOSE SESSION
        session.close();
    }
}