package com.example.service;

import com.example.dto.StudentRequest;

import com.example.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(
            StudentRequest request
    );

    void deleteStudent(Long id);
}