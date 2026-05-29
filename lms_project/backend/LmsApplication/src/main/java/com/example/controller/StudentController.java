package com.example.controller;

import com.example.dto.StudentRequest;

import com.example.entity.Student;

import com.example.service.StudentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/students")

@CrossOrigin("*")

public class StudentController {

    private final StudentService studentService;

    public StudentController(
            StudentService studentService
    ) {

        this.studentService =
                studentService;
    }

    @GetMapping

    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }

    @PostMapping

    public Student saveStudent(

            @RequestBody
            StudentRequest request

    ) {

        return studentService.saveStudent(
                request
        );
    }

    @DeleteMapping("/{id}")

    public void deleteStudent(
            @PathVariable Long id
    ) {

        studentService.deleteStudent(id);
    }
}