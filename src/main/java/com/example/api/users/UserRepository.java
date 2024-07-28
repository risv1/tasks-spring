package com.example.api.users;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.database.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

}
