package com.company.repo;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.entity.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {

    // JPQL
    @Query("select t from Teacher t")
    List<Teacher> findAllTeachers();

    // ENTITY GRAPH
    @EntityGraph(attributePaths = {"emails"})
    List<Teacher> findAll();
}