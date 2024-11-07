package com.project.oop.PMS.controller;

import com.project.oop.PMS.entity.User;
import com.project.oop.PMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        try {
            User newUser = userService.registerUser(username, password);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "User registered successfully");
            Map<String, Object> userData = new HashMap<>();
            userData.put("id", newUser.getUserID());
            userData.put("username", newUser.getName());
            response.put("user", userData);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

        return userService.loginUser(username, password)
                .map(user -> {
                    Map<String, Object> response = new HashMap<>();
                    response.put("message", "User login successfully");
                    Map<String, Object> userData = new HashMap<>();
                    userData.put("id", user.getUserID());
                    userData.put("username", user.getName());
                    response.put("user", userData);
                    return ResponseEntity.ok(response);
                })
                .orElseGet(() -> {
                    Map<String, Object> errorResponse = new HashMap<>();
                    errorResponse.put("message", "Invalid username or password");
                    return ResponseEntity.status(401).body(errorResponse);
                });
    }
}
