package com.example; // Ensure this matches the package of UserController

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example") // This ensures your controller is detected
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
