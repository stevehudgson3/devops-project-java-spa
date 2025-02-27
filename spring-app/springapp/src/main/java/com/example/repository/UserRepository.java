package com.example; // Defines the package for this interface

import org.springframework.data.jpa.repository.JpaRepository; // Imports JPA repository

// UserRepository interface extends JpaRepository to provide database operations for User entity
public interface UserRepository extends JpaRepository<User, Long> {
    // No need to write SQL queries; JpaRepository provides CRUD methods automatically
}

