package com.example.repository;

import com.example.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByUsername(String username);
    List<UserAccount> findByRole(String role);
    boolean existsByUsername(String username);
}