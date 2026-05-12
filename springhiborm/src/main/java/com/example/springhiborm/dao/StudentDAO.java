package com.example.springhiborm.dao;

import com.example.springhiborm.entity.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;


    // INSERT ONLY
    public void saveStudent(Student student) {

        sessionFactory
                .getCurrentSession()
                .save(student);
    }
}