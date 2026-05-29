package com.example.controller;

import com.example.repository.UserAccountRepository;
import com.example.service.UserAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/setup")
public class SetupController {

    private final UserAccountService userAccountService;
    private final UserAccountRepository userAccountRepository;

    public SetupController(UserAccountService userAccountService,
                           UserAccountRepository userAccountRepository) {
        this.userAccountService = userAccountService;
        this.userAccountRepository = userAccountRepository;
    }

    @GetMapping
    public String setupPage() {
        // If admin already exists, skip setup
        if (userAccountRepository.existsByUsername("admin") ||
                !userAccountRepository.findByRole("ROLE_ADMIN").isEmpty()) {
            return "redirect:/login";
        }
        return "setup";
    }

    @PostMapping("/save")
    public String saveSetup(@RequestParam String adminUsername,
                            @RequestParam String adminPassword) {
        if (!userAccountRepository.findByRole("ROLE_ADMIN").isEmpty()) {
            return "redirect:/login";
        }
        userAccountService.createUser(adminUsername, adminPassword, "Admin", "ROLE_ADMIN");
        return "redirect:/login?setupDone";
    }
}