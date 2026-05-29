package com.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "students")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private String email;

    private String status = "Active";

    @ManyToMany(fetch = FetchType.EAGER)

    @JoinTable(

            name = "student_courses",

            joinColumns =
            @JoinColumn(name = "student_id"),

            inverseJoinColumns =
            @JoinColumn(name = "course_id")
    )

    private List<Course> courses;

    public Student() {
    }

    public Student(

            String name,
            String email,
            String status,
            List<Course> courses

    ) {

        this.name = name;
        this.email = email;
        this.status = status;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(
            Long id
    ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(
            String name
    ) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(
            String email
    ) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(
            String status
    ) {
        this.status = status;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(
            List<Course> courses
    ) {
        this.courses = courses;
    }
}