package com.example.api.users;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.database.UserEntity;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> getUsers() {
        List<UserEntity> allUsers = userRepository.findAll();
        return UserModel.fromEntityList(allUsers);
    }

    public UserModel getUserById(UUID id) {
        UserEntity user = userRepository.findById(id).orElse(null);
        return UserModel.fromEntity(user);
    }


    public UserModel updateUser(UUID id, UserModel user) {
        UserEntity userToUpdate = userRepository.findById(id).orElse(null);
        if (userToUpdate == null) {
            return null;
        }

        if (user.role != null) {
            userToUpdate.setRole(user.role);
        }
        userToUpdate.setUpdatedAt(LocalDate.now().toString());

        userRepository.save(userToUpdate);

        return UserModel.fromEntity(userToUpdate);
    }

    public UserModel deleteUser(UUID id) {
        UserEntity userToDelete = userRepository.findById(id).orElse(null);
        if (userToDelete == null) {
            return null;
        }

        userRepository.delete(userToDelete);

        return UserModel.fromEntity(userToDelete);
    }
}
