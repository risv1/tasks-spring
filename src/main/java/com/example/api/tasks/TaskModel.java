package com.example.api.tasks;

public class TaskModel {

    public final String id;
    public final String title;
    public final String description;
    public final String status;
    public final String assignee;
    public final String dueDate;
    public final String createdAt;
    public final String updatedAt;

    public TaskModel(
            String id,
            String title,
            String description,
            String status,
            String assignee,
            String dueDate,
            String createdAt,
            String updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.assignee = assignee;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}

