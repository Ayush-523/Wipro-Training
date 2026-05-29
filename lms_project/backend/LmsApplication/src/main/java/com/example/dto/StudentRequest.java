package com.example.dto;

import java.util.List;

public class StudentRequest {

    private String name;

    private String email;

    private String status;

    private List<Long> courses;

    public StudentRequest() {
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

    public List<Long> getCourses() {
        return courses;
    }

    public void setCourses(
            List<Long> courses
    ) {
        this.courses = courses;
    }
}