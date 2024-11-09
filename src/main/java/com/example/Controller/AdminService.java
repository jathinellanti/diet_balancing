package com.example.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Interface.UserInterface;
import com.example.Model.User;
import com.example.repository.DAO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdminService {

    @Autowired
    DAO dao;
    
    @Autowired
    UserInterface userInterface;

    // Sign Up
    @PostMapping("/users")
    public ResponseEntity<Map<String, String>> register(@RequestBody User user) {
        Map<String, String> response = new HashMap<>();

        // Check if email already exists
        if (userInterface.findByEmail(user.getEmail()) != null) {
            response.put("message", "Email already exists");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT); // 409 Conflict
        }

        // Insert the user
        dao.insert(user);
        response.put("message", "User registered successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED); // 201 Created
    }
    
    @GetMapping("/users/check-email")
    public ResponseEntity<Map<String, Boolean>> checkEmail(@RequestParam String email) {
        boolean exists = userInterface.findByEmail(email) != null;
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return ResponseEntity.ok(response);
    }
}
