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
@Table(name = "tasks")
@EntityListeners(AuditingEntityListener.class)
public class TaskEntity {
    
    public TaskEntity() {}

    public TaskEntity(String title, String description, String assignee, String status, String dueDate, String createdAt, String updatedAt) {
        this.title = title;
        this.description = description;
        this.assignee = assignee;
        this.status = status;
        this.dueDate = dueDate;
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

    @Column(name = "title", nullable = false)
    public String title;

    @Column(name = "description", nullable = false)
    public String description;

    @Column(name = "assignee", nullable = false)
    public String assignee;

    @Column(name = "status", nullable = false)
    public String status;

    @Column(name = "due_date", nullable = false)
    public String dueDate;

    @Column(name = "created_at", nullable = false)
    public String createdAt;

    @Column(name = "updated_at", nullable = false)
    public String updatedAt;

    public String getId() {
        return id.toString();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getStatus() {
        return status;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
