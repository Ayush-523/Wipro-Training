package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reportcard")
public class ReportCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int marks;

    private String grade;

    public ReportCard() {
    }

    public int getId() {
        return id;
    }

    public int getMarks() {
        return marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}