package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String course;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reportcard_id")
    private ReportCard reportCard;

    public Student() {
    }

    public Student(String name, String course, ReportCard reportCard) {
        this.name = name;
        this.course = course;
        this.reportCard = reportCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }


    public ReportCard getReportCard() {
        return reportCard;
    }

    public void setReportCard(ReportCard reportCard) {
        this.reportCard = reportCard;
    }

    @Override
    public String toString() {
        return "Student [id=" + id +
                ", name=" + name +
                ", course=" + course + "]";
    }
}