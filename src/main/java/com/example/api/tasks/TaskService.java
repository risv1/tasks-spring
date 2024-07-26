package com.example.api.tasks;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    public List<TaskModel> getTasks() {
        TaskModel task1 = new TaskModel(
                "1",
                "Task 1",
                "Description 1",
                "Pending",
                "123",
                "2021-01-01",
                "2021-01-01",
                "2021-01-01");

        TaskModel task2 = new TaskModel(null, null, null, null, null, null, null, null);
        
        List<TaskModel> tasks = List.of(task1, task2);

        return tasks;
    }

    public static TaskModel getTaskById(String id) {
        TaskModel task = new TaskModel(
                id,
                "Task 1",
                "Description 1",
                "Pending",
                "123",
                "2021-01-01",
                "2021-01-01",
                "2021-01-01");

        return task;
    }

    public TaskModel createTask(TaskModel task) {
        TaskModel newTask = new TaskModel(
                "2",
                task.title,
                task.description,
                "123",
                "Pending",
                task.dueDate,
                "2021-01-01",
                "2021-01-01");

        return newTask;
    }

    public TaskModel updateTask(String id, TaskModel task) {
        TaskModel updatedTask = new TaskModel(
                id,
                task.title,
                task.description,
                task.status,
                "123",
                task.dueDate,
                "2021-01-01",
                "2021-01-01");

        return updatedTask;
    }

    public TaskModel deleteTask(String id) {
        TaskModel task = new TaskModel(
                id,
                "Task 1",
                "Description 1",
                "Pending",
                "123",
                "2021-01-01",
                "2021-01-01",
                "2021-01-01");

        return task;
    }
}
