package com.example.geh.service;

import com.example.geh.exception.AgeNotFoundException;
import com.example.geh.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    // Temporary List to store users
    private final List<User> userList = new ArrayList<>();

    // Save User
    public User saveUser(User user) {

        if (user.getAge() < 18) {

            throw new AgeNotFoundException(
                    "Age should be greater than 18"
            );
        }

        userList.add(user);

        return user;
    }

    // View All Users
    public List<User> getAllUsers() {

        return userList;
    }
}