package com.example.geh.model;

public class User {

    private Long id;
    private int age;
    private String aadharNo;
    private String panNo;

    public User() {
    }

    public User(Long id, int age, String aadharNo, String panNo) {
        this.id = id;
        this.age = age;
        this.aadharNo = aadharNo;
        this.panNo = panNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }
}