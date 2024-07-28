package com.example.api.tasks;

import java.util.List;
import java.util.stream.Collectors;
import com.example.database.TaskEntity;

public class TaskModel {

    public String id;
    public String title;
    public String description;
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

    public static TaskModel fromEntity(TaskEntity entity) {
        TaskModel model = new TaskModel(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getStatus(),
                entity.getAssignee(),
                entity.getDueDate(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
        return model;
    }

    public static List<TaskModel> fromEntityList(List<TaskEntity> entities) {
        return entities.stream()
                       .map(TaskModel::fromEntity)
                       .collect(Collectors.toList());
    }

}

