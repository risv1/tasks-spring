package com.example.api.tasks;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private final TaskService service;

    public TaskController(TaskService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<TaskModel>> getAllTasks(){
        return ResponseEntity.ok(service.getTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskModel> getTaskById(@PathVariable("id") String id){
        return ResponseEntity.ok(TaskService.getTaskById(id));
    }

    @PostMapping
    public ResponseEntity<TaskModel> createTask(TaskModel task){
        return ResponseEntity.ok(service.createTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskModel> updateTask(@PathVariable("id") String id, TaskModel task){
        return ResponseEntity.ok(service.updateTask(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskModel> deleteTask(@PathVariable("id") String id){
        return ResponseEntity.ok(service.deleteTask(id));
    }
    
}
