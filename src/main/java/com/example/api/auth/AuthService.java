package com.example.api.auth;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public AuthModel registerUser(AuthModel user) {
        return new AuthModel(
                "1",
                user.username,
                user.email,
                user.password,
                "User",
                "2021-01-01",
                "2021-01-01");
    }
    
    public AuthModel loginUser(AuthModel user) {
        return new AuthModel(
                "1",
                user.username,
                user.email,
                user.password,
                "User",
                "2021-01-01",
                "2021-01-01");  
    }

    public String logoutUser() {
        return "User logged out";
    }
}
