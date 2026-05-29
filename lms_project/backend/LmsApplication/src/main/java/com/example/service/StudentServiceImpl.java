package com.example.service;

import com.example.dto.StudentRequest;

import com.example.entity.Course;
import com.example.entity.Student;

import com.example.repository.CourseRepository;
import com.example.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentServiceImpl
        implements StudentService {

    private final StudentRepository repository;

    private final CourseRepository courseRepository;

    public StudentServiceImpl(

            StudentRepository repository,

            CourseRepository courseRepository

    ) {

        this.repository = repository;

        this.courseRepository =
                courseRepository;
    }

    @Override

    public List<Student> getAllStudents() {

        return repository.findAll();
    }

    @Override

    public Student saveStudent(
            StudentRequest request
    ) {

        List<Course> selectedCourses =
                courseRepository.findAllById(
                        request.getCourses()
                );

        Student student = new Student();

        student.setName(
                request.getName()
        );

        student.setEmail(
                request.getEmail()
        );

        student.setStatus(
                request.getStatus()
        );

        student.setCourses(
                selectedCourses
        );

        return repository.save(
                student
        );
    }

    @Override

    public void deleteStudent(
            Long id
    ) {

        repository.deleteById(id);
    }
}