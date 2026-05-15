package com.example.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // MANY TO MANY
    @ManyToMany(cascade = CascadeType.ALL)

    @JoinTable(
            name = "student_course",

            joinColumns =
            @JoinColumn(name = "student_id"),

            inverseJoinColumns =
            @JoinColumn(name = "course_id")
    )

    private List<Course> courses =
            new ArrayList<>();

    // DEFAULT CONSTRUCTOR
    public Student() {
    }

    // PARAMETERIZED CONSTRUCTOR
    public Student(String name) {

        this.name = name;
    }

    // GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {

        return courses;
    }

    public void setCourses(
            List<Course> courses) {

        this.courses = courses;
    }

    // ADD COURSE METHOD

    public void addCourse(Course c) {

        this.courses.add(c);

        // SYNCHRONIZATION
        c.getStudents().add(this);
    }
}