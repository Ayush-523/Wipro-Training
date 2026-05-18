package com.company.repo;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

    // JPQL
    @Query("select s from Student s")
    List<Student> findAllStudents();

    // EntityGraph
    @EntityGraph(attributePaths = {"emails"})
    List<Student> findAll();
}