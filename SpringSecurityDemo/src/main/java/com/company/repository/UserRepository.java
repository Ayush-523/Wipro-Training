package com.company.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.AppUser;

public interface UserRepository
        extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByUsername(String username);
}