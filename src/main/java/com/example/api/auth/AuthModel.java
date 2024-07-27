package com.example.api.auth;

public class AuthModel {

    public String username;
    public String email;
    public String password;
    public String role;
    public String createdAt;
    public String updatedAt;

    public AuthModel(

            String username,
            String email,
            String password,
            String role,
            String createdAt,
            String updatedAt) {

        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
