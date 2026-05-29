//package com.example.controller;
//
//import com.example.entity.UserAccount;
//import com.example.repository.UserAccountRepository;
//import lombok.Data;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/auth")
//@CrossOrigin(origins = "http://localhost:5173")
//public class AuthController {
//
//    private final UserAccountRepository repository;
//    private final PasswordEncoder encoder;
//
//    public AuthController(UserAccountRepository repository,
//                          PasswordEncoder encoder) {
//        this.repository = repository;
//        this.encoder = encoder;
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
//
//        UserAccount user = repository
//                .findByUsername(request.getUsername())
//                .orElse(null);
//
//        if (user == null) {
//            return ResponseEntity.badRequest()
//                    .body("User not found");
//        }
//
//        if (!request.getPassword().equals(user.getPassword())) {
//            return ResponseEntity.badRequest()
//                    .body("Invalid password");
//        }
//
//        return ResponseEntity.ok(user);
//    }
//
//    @Data
//    static class LoginRequest {
//        private String username;
//        private String password;
//    }
//}

package com.example.controller;

import com.example.entity.UserAccount;
import com.example.repository.UserAccountRepository;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5176")
public class AuthController {

    private final UserAccountRepository repository;

    public AuthController(UserAccountRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request
    ) {

        UserAccount user = repository
                .findByUsername(request.getUsername())
                .orElse(null);

        if (user == null) {

            return ResponseEntity
                    .badRequest()
                    .body("User not found");
        }

        // plain password compare
        if (!request.getPassword()
                .equals(user.getPassword())) {

            return ResponseEntity
                    .badRequest()
                    .body("Invalid password");
        }

        return ResponseEntity.ok(user);
    }

    @Data
    static class LoginRequest {

        private String username;

        private String password;
    }
}