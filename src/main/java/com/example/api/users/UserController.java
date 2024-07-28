package com.example.api.users;

import java.util.UUID;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<UserResponses> getUsers() {
        List<UserModel> users = service.getUsers();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(new UserResponses(users, "Users retrieved"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") UUID id) {
        UserModel user = service.getUserById(id);
        if (user == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(new UserResponse(user, "User retrieved"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable("id") UUID id, @RequestBody UserModel user) {
        UserModel updatedUser = service.updateUser(id, user);
        if (updatedUser == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(new UserResponse(updatedUser, "User updated"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable("id") UUID id) {
        UserModel deletedUser = service.deleteUser(id);
        if (deletedUser == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(new UserResponse(deletedUser, "User deleted"));
    }
}
