package com.example.api.users;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public List<UserModel> getUsers() {
        return List.of(new UserModel(null, null, null, null, null, null, null));
    }

    public UserModel getUserById(String id) {
        return new UserModel(
                id,
                "User 1",
                "user1@gmail.com",
                "password",
                "User",
                "2021-01-01",
                "2021-01-01");
    }
    
    public UserModel createUser(UserModel user) {
        return new UserModel(
                "1",
                user.username,
                user.email,
                user.password,
                user.role,
                "2021-01-01",
                "2021-01-01");
    }

    public UserModel updateUser(String id, UserModel user) {
        return new UserModel(
                id,
                user.username,
                user.email,
                user.password,
                user.role,
                "2021-01-01",
                "2021-01-01");
    }

    public String deleteUser(String id) {
        return "User deleted";
    }
}
