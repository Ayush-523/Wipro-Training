package com.company.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.company.dto.UserRequestDTO;
import com.company.entity.AppUser;
import com.company.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;



    @GetMapping("/public/home")
    public String home() {

        return "Welcome Public Home";
    }

    // REGISTER USER

    @PostMapping("/register")
    public String registerUser(
            @RequestBody UserRequestDTO request) {

        AppUser user = new AppUser();

        user.setUsername(request.getUsername());

        user.setPassword(

                passwordEncoder.encode(
                        request.getPassword()
                )
        );

        user.setRole(
                "ROLE_" + request.getRole()
        );

        userRepository.save(user);

        return "User Registered Successfully";
    }

    // USER API

    @GetMapping("/api/user/data")
    public String userData() {

        return "User Data Accessed";
    }

    // ADMIN API

    @GetMapping("/api/admin/data")
    public String adminData() {

        return "Admin Data Accessed";
    }
}