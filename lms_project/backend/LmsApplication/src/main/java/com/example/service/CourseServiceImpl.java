package com.example.service;

import com.example.entity.Course;
import com.example.exception.CourseNotFoundException;
import com.example.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    @Override
    public void deleteCourse(Long id) {

        Course course = repository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course does not exist"));

        repository.delete(course);
    }
}