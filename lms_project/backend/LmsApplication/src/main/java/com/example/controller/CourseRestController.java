package com.example.controller;

import com.example.entity.Course;

import com.example.service.CourseService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/courses")

@CrossOrigin("*")

public class CourseRestController {

    private final CourseService courseService;

    public CourseRestController(
            CourseService courseService
    ) {

        this.courseService =
                courseService;
    }

    @GetMapping

    public List<Course> getAllCourses() {

        return courseService.getAllCourses();
    }

    @PostMapping

    public Course addCourse(

            @RequestBody Course course

    ) {

        return courseService.saveCourse(
                course
        );
    }

    @DeleteMapping("/{id}")

    public void deleteCourse(
            @PathVariable Long id
    ) {

        courseService.deleteCourse(id);
    }
}