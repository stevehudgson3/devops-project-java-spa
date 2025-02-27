package com.example; // Correct package declaration

import jakarta.persistence.*; // Imports JPA annotations for database mapping

// Declares this class as a JPA entity that maps to a database table
@Entity
public class User {
    
    // Defines the primary key of the entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generates unique ID values
    private Long id;
    
    private String name;    
    private String email;   
    private String message; 

    // Default constructor (needed for JPA)
    public User() {}

    // Constructor to initialize User object with values
    public User(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }       

    // Getters and setters (used to access and modify the fields)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; } // ✅ Fixed String casing
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}

