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

    public ReportCard(int marks, String grade) {
        this.marks = marks;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }


    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ReportCard [id=" + id +
                ", marks=" + marks +
                ", grade=" + grade + "]";
    }
}