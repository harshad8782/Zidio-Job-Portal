package com.zidio.jobportal.controller;

import com.zidio.jobportal.dto.AuthResponse;
import com.zidio.jobportal.dto.LoginRequest;
import com.zidio.jobportal.dto.RegisterRequest;
import com.zidio.jobportal.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // @PostMapping("/register")
    // public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
    //     AuthResponse response = authService.register(request);
    //     System.out.println("📥 REGISTER REQ:");
    // System.out.println("Name: " + request.getName());
    // System.out.println("Email: " + request.getEmail());
    // System.out.println("Password: " + request.getPassword());
    // System.out.println("Role: " + request.getRole());
    //     return ResponseEntity.ok(response);
    // }

    @PostMapping("/register")
public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
    System.out.println("📥 Received register: " + request.getEmail() + ", " + request.getRole());
    System.out.println("➡️ Incoming Register:");
    System.out.println("Name: " + request.getName());
    System.out.println("Email: " + request.getEmail());
    System.out.println("Password: " + request.getPassword());
    System.out.println("Role: " + request.getRole());
    AuthResponse response = authService.register(request);
    return ResponseEntity.ok(response);
}


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}

