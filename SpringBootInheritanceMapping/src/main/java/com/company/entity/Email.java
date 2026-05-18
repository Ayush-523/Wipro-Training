package com.company.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

@Table(name = "email")

public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    // FOR STUDENT
    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "student_id")

    private Student student;

    // FOR TEACHER
    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "teacher_id")

    private Teacher teacher;

    // STUDENT CONSTRUCTOR
    public Email(String email, Student student) {

        this.email = email;
        this.student = student;
    }

    // TEACHER CONSTRUCTOR
    public Email(String email, Teacher teacher) {

        this.email = email;
        this.teacher = teacher;
    }
}