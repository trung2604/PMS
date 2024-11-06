package com.project.oop.PMS.controller;

import com.project.oop.PMS.entity.LoginRequest;
import com.project.oop.PMS.entity.RegisterRequest;
import com.project.oop.PMS.entity.User;
import com.project.oop.PMS.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = authService.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
            return ResponseEntity.ok().body(
                Map.of(
                    "message", "User login successfully",
                    "user", Map.of(
                        "id", user.getId(),
                        "username", user.getUsername()
                    )
                )
            );
        } else {
            return ResponseEntity.status(401).body(
                Map.of("message", "Invalid username or password")
            );
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        User user = authService.register(registerRequest.getUsername(), registerRequest.getPassword());
        if (user != null) {
            return ResponseEntity.ok().body(
                Map.of(
                    "message", "User registered successfully",
                    "user", Map.of(
                        "id", user.getId(),
                        "username", user.getUsername()
                    )
                )
            );
        } else {
            return ResponseEntity.status(400).body(
                Map.of("message", "Username is already taken")
            );
        }
    }
}
