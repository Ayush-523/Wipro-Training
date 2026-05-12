package com.example.springhiborm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springhiborm.dao.StudentDAO;
import com.example.springhiborm.entity.Student;

@Service
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public void saveStudent(Student student) {
        studentDAO.saveStudent(student);
    }
}