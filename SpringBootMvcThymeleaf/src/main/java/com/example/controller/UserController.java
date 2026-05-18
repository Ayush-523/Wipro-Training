package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {

        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user, Model model) {

        userService.saveUser(user);
        model.addAttribute("msg", "Registration Successful");

        return "login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/loginUser")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            Model model) {

        User validUser = userService.loginUser(email, password);

        if (validUser != null) {
            model.addAttribute("users", userService.getAllUsers());
            return "display";
        }
        else {
            model.addAttribute("error", "Invalid Email or Password");
            return "login";
        }
    }

    @GetMapping("/service")
    public String servicePage() {
        return "service";
    }
}