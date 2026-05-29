package com.example.controller;

import com.example.service.UserAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin/users")
public class UserManagementController {

    private final UserAccountService userAccountService;

    public UserManagementController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userAccountService.getAllUsers());
        return "manage-users";
    }

    @PostMapping("/add")
    public String addUser(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String displayName,
                          @RequestParam String role,
                          RedirectAttributes ra) {
        if (userAccountService.usernameExists(username)) {
            ra.addFlashAttribute("error", "Username already exists!");
            return "redirect:/admin/users";
        }
        userAccountService.createUser(username, password, displayName, role);
        ra.addFlashAttribute("success", "User created successfully!");
        return "redirect:/admin/users";
    }

    @PostMapping("/update-password/{id}")
    public String updatePassword(@PathVariable Long id,
                                 @RequestParam String newPassword,
                                 RedirectAttributes ra) {
        userAccountService.updatePassword(id, newPassword);
        ra.addFlashAttribute("success", "Password updated successfully!");
        return "redirect:/admin/users";
    }

    @PostMapping("/update-username/{id}")
    public String updateUsername(@PathVariable Long id,
                                 @RequestParam String newUsername,
                                 RedirectAttributes ra) {
        if (userAccountService.usernameExists(newUsername)) {
            ra.addFlashAttribute("error", "Username already taken!");
            return "redirect:/admin/users";
        }
        userAccountService.updateUsername(id, newUsername);
        ra.addFlashAttribute("success", "Username updated successfully!");
        return "redirect:/admin/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, RedirectAttributes ra) {
        userAccountService.deleteUser(id);
        ra.addFlashAttribute("success", "User deleted.");
        return "redirect:/admin/users";
    }
}