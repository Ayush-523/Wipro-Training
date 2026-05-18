package com.company.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.entity.Student;
import com.company.entity.Teacher;
import com.company.repo.StudentRepo;
import com.company.repo.TeacherRepo;

@Service
public class StudentService {

    // STUDENT REPO
    private final StudentRepo students;

    // TEACHER REPO
    private final TeacherRepo teachers;

    // CONSTRUCTOR INJECTION
    public StudentService(StudentRepo students,
                          TeacherRepo teachers) {

        this.students = students;
        this.teachers = teachers;
    }

    // SAVE STUDENT
    public Student save(Student s) {

        return students.save(s);
    }

    // FETCH STUDENTS WITH EMAILS
    public List<Student> findAllWithEmails() {

        return students.findAll();
    }

    // SAVE TEACHER
    public Teacher saveTeacher(Teacher t) {

        return teachers.save(t);
    }

    // FETCH TEACHERS WITH EMAILS
    public List<Teacher> findAllTeachersWithEmails() {

        return teachers.findAll();
    }
}