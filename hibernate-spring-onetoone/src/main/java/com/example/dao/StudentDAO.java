package com.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Student;

@Repository
public class StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveStudent(Student student) {

        Session session =
                sessionFactory.openSession();

        session.beginTransaction();

        session.persist(student);

        session.getTransaction().commit();

        session.close();
    }
}