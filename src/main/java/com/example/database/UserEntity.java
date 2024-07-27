package com.example.database;

import java.util.UUID;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {

    public UserEntity() {}

    public UserEntity(String username, String email, String hashedPassword, String role, String createdAt, String updatedAt) {
        this.username = username;
        this.email = email;
        this.password = hashedPassword;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    public UUID id;

    @Column(name = "username", nullable = false)
    public String username;

    @Column(name = "email", nullable = false)
    public String email;

    @Column(name = "password", nullable = false)
    public String password;

    @Column(name = "role", nullable = false)
    public String role;

    @Column(name = "created_at", nullable = false)
    public String createdAt;

    @Column(name = "updated_at", nullable = false)
    public String updatedAt;

}