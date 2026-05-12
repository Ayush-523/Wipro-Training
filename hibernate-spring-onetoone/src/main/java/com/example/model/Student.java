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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public ReportCard getReportCard() {
        return reportCard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setReportCard(ReportCard reportCard) {
        this.reportCard = reportCard;
    }
}