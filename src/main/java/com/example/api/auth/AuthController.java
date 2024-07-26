package com.example.api.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private final AuthService service;

    public AuthController(AuthService service){
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthModel> registerUser(AuthModel user) {
        return ResponseEntity.ok(service.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthModel> loginUser(AuthModel user) {
        return ResponseEntity.ok(service.loginUser(user));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser() {
        return ResponseEntity.ok(service.logoutUser());
    }
}
