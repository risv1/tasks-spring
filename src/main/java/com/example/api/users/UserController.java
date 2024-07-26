package com.example.api.users;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getUsers() {
        return ResponseEntity.ok(service.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<UserModel> createUser(UserModel user) {
        return ResponseEntity.ok(service.createUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable("id") String id, UserModel user) {
        return ResponseEntity.ok(service.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.deleteUser(id));
    }
}
