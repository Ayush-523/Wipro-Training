package com.company.securitydemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // HOME

    @GetMapping("/")
    public String home() {

        return "Spring Security Project Running";
    }

    // LOGIN SUCCESS

    @GetMapping("/success")
    public String success() {

        return "Logged In Successfully";
    }

    // PUBLIC API

    @GetMapping("/public/welcome")
    public String getWelcome() {

        return "Welcome to our Hotel";
    }

    // USER API

    @GetMapping("/api/user/userinfo")
    public String getVoucher() {

        return "Your voucher code is generated";
    }

    // ADMIN API

    @GetMapping("/api/admin/admininfo")
    public String getUserInfo() {

        return "Admin dashboard opened";
    }
}