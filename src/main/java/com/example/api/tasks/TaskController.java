package com.example.api.tasks;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.middlewares.AdminMiddleware;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private final TaskService service;

    public TaskController(TaskService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<TaskResponses> getAllTasks(){
        List<TaskModel> tasks = service.getTasks();
        if (tasks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(new TaskResponses(tasks, "Tasks retrieved"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable("id") UUID id){
        return ResponseEntity.ok(new TaskResponse(service.getTaskById(id), "Task retrieved"));
    }

    @GetMapping("/assignee/{assignee}")
    public ResponseEntity<TaskResponses> getTasksByAssignee(@PathVariable("assignee") String assignee){
        List<TaskModel> tasks = service.getTasksByAssignee(assignee);
        if (tasks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(new TaskResponses(tasks, "Tasks retrieved"));
    }

    @PostMapping
    @AdminMiddleware
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskModel task){
        return ResponseEntity.ok(new TaskResponse(service.createTask(task), "Task created"));
    }

    @PutMapping("/{id}")
    @AdminMiddleware
    public ResponseEntity<TaskResponse> updateTask(@PathVariable("id") UUID id, @RequestBody TaskModel task){
        return ResponseEntity.ok(new TaskResponse(service.updateTask(id, task), "Task updated"));
    }

    @PutMapping("/{id}/status")
    @AdminMiddleware
    public ResponseEntity<TaskResponse> updateTaskStatus(@PathVariable("id") UUID id){
        return ResponseEntity.ok(new TaskResponse(service.markTaskComplete(id), "Task status updated"));
    }

    @DeleteMapping("/{id}")
    @AdminMiddleware
    public ResponseEntity<TaskResponse> deleteTask(@PathVariable("id") UUID id){
        return ResponseEntity.ok(new TaskResponse(service.deleteTask(id), "Task deleted"));
    }
    
}
