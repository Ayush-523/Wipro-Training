package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.StudentDAO;
import com.example.model.Student;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public void addStudent(Student student) {

        studentDAO.saveStudent(student);
    }
}