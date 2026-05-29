package com.example.service;

import com.example.entity.UserAccount;
import java.util.List;

public interface UserAccountService {
    UserAccount createUser(String username, String password, String displayName, String role);
    UserAccount updatePassword(Long id, String newPassword);
    UserAccount updateUsername(Long id, String newUsername);
    void deleteUser(Long id);
    List<UserAccount> getAllUsers();
    List<UserAccount> getUsersByRole(String role);
    UserAccount getUserById(Long id);
    boolean usernameExists(String username);
}