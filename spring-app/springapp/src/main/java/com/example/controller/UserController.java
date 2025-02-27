package com.example; // Defines the package for this class

import org.springframework.beans.factory.annotation.Autowired; // Enables dependency injection
import org.springframework.http.ResponseEntity; // Handles HTTP responses
import org.springframework.web.bind.annotation.*; // Imports REST API annotations

import java.util.List; // Imports List to return multiple users

// Declares this class as a REST controller to handle HTTP requests
@RestController
@RequestMapping("/api/users") // Defines the base API endpoint
public class UserController {

    @Autowired // Injects an instance of UserRepository automatically
    private UserRepository userRepository;

    // Handles HTTP POST requests to save a new user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user)); // Saves user and returns it
    }

    // Handles HTTP GET requests to retrieve all users
    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll(); // Fetches all users from the database
    }
}

