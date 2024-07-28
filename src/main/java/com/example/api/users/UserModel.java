package com.example.api.users;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import com.example.database.UserEntity;

public class UserModel {
    
    public String id;
    public String username;
    public String email;
    public String password;
    public String role;
    public String createdAt;
    public String updatedAt;

    public UserModel(
            String id,
            String username,
            String email,
            String password,
            String role,
            String createdAt,
            String updatedAt) {

        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static UserModel fromEntity(UserEntity entity) {
        UserModel model = new UserModel(
                entity.getId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRole(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        return model;
    }

    public static List<UserModel> fromEntityList(List<UserEntity> entities) {
        return entities.stream()
                       .map(UserModel::fromEntity)
                       .collect(Collectors.toList());
    }
}
