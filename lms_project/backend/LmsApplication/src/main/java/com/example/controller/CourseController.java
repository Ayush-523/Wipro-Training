package com.example.controller;

import com.example.entity.Course;
import com.example.repository.CourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin("*")
public class CourseController {

    private final CourseRepository repository;

    public CourseController(CourseRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return repository.save(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        repository.deleteById(id);
    }
}