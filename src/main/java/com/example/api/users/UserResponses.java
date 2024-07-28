package com.example.api.users;

import java.util.List;

final class UserResponses {

    public List<UserModel> users;
    public String message;

    public UserResponses(List<UserModel> users, String message) {
        this.users = users;
        this.message = message;
    }
}

final class UserResponse {

    public UserModel user;
    public String message;

    public UserResponse(UserModel user, String message) {
        this.user = user;
        this.message = message;
    }
}
