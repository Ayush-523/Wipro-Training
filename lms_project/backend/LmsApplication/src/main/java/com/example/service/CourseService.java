package com.example.service;

import com.example.entity.Course;

import java.util.List;

public interface CourseService {

    Course saveCourse(Course course);

    List<Course> getAllCourses();

    void deleteCourse(Long id);
}