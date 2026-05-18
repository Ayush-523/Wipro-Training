package com.company.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.*;

import com.company.model.User;

import com.company.repository.UserRepository;

import com.company.security.JwtUtil;

@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {

        Optional<User> optionalUser =
                userRepository.findByUsername(
                        loginRequest.getUsername());

        if (optionalUser.isPresent()) {

            User user = optionalUser.get();

            if (passwordEncoder.matches(
                    loginRequest.getPassword(),
                    user.getPassword())) {

                String token =
                        jwtUtil.generateToken(user.getRole());

                Map<String, String> response =
                        new HashMap<>();

                response.put("token", token);

                response.put("role", user.getRole());

                return ResponseEntity.ok(response);
            }
        }

        return ResponseEntity.badRequest()
                .body("Invalid Credentials");
    }
}