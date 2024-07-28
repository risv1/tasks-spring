package com.example.api.tasks;

import java.util.List;

final class TaskResponses {
    
    public List<TaskModel> tasks;
    public String message;
    
    public TaskResponses(List<TaskModel> tasks, String message) {
        this.tasks = tasks;
        this.message = message;
    }
}

final class TaskResponse {
        
        public TaskModel task;
        public String message;
        
        public TaskResponse(TaskModel task, String message) {
            this.task = task;
            this.message = message;
        }
}
