package com.example.geh.controller;

import com.example.geh.model.User;
import com.example.geh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Save User
    @PostMapping
    public User saveUser(@RequestBody User user) {

        return userService.saveUser(user);
    }

    // View All Users
    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }
}