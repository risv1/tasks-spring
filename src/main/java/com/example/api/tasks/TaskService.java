package com.example.api.tasks;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.database.TaskEntity;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskModel> getTasks() {
        List<TaskEntity> allTasks = taskRepository.findAll();
        return TaskModel.fromEntityList(allTasks);
    }

    public TaskModel getTaskById(UUID id) {
        TaskEntity task = taskRepository.findById(id).orElse(null);
        return TaskModel.fromEntity(task);
    }

    public TaskModel createTask(TaskModel task) {
        TaskEntity newTask = new TaskEntity(
                task.title,
                task.description,
                task.assignee,
                "Pending",
                task.dueDate,
                LocalDate.now().toString(),
                LocalDate.now().toString()
        );
        taskRepository.save(newTask);
        return TaskModel.fromEntity(newTask);
    }

    public TaskModel updateTask(UUID id, TaskModel task) {
        TaskEntity taskToUpdate = taskRepository.findById(id).orElse(null);
        if (taskToUpdate == null) {
            return null;
        }

        if(task.title != null){
            taskToUpdate.setTitle(task.title);
        }
        if(task.description != null){
            taskToUpdate.setDescription(task.description);
        }
        if(task.assignee != null){
            taskToUpdate.setAssignee(task.assignee);
        }
        if(task.status != null){
            taskToUpdate.setStatus(task.status);
        }
        if(task.dueDate != null){
            taskToUpdate.setDueDate(task.dueDate);
        }
        taskToUpdate.setUpdatedAt(LocalDate.now().toString());

        taskRepository.save(taskToUpdate);

        return TaskModel.fromEntity(taskToUpdate);
    }

    public TaskModel deleteTask(UUID id) {
       TaskEntity taskToDelete = taskRepository.findById(id).orElse(null);
        if (taskToDelete == null) {
            return null;
        }

        taskRepository.delete(taskToDelete);

        return TaskModel.fromEntity(taskToDelete);
    }

    public List<TaskModel> getTasksByAssignee(String assignee) {
        List<TaskEntity> tasks = taskRepository.findByAssignee(assignee);
        return TaskModel.fromEntityList(tasks);
    }

    public TaskModel markTaskComplete(UUID id) {
        TaskEntity task = taskRepository.findById(id).orElse(null);
        if (task == null) {
            return null;
        }

        task.setStatus("Completed");
        task.setUpdatedAt(LocalDate.now().toString());

        taskRepository.save(task);

        return TaskModel.fromEntity(task);
    }
}
