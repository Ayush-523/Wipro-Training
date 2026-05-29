package com.example.repository;

import com.example.entity.AdminConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminConfigRepository extends JpaRepository<AdminConfig, Long> {
    AdminConfig findTopByOrderByIdAsc();
}