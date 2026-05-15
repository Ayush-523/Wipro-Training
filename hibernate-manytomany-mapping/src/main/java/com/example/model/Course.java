package com.example.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(
            mappedBy = "courses",
            cascade = CascadeType.ALL
    )

    private List<Student> students =
            new ArrayList<>();

    // DEFAULT CONSTRUCTOR
    public Course() {
    }

    // PARAMETERIZED CONSTRUCTOR
    public Course(String title) {

        this.title = title;
    }

    // GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudents() {

        return students;
    }

    public void setStudents(
            List<Student> students) {

        this.students = students;
    }
}