package com.marvin.demo.bundle.todo.business;

import java.util.List;
import com.marvin.demo.bundle.todo.model.Task;
import com.marvin.demo.bundle.todo.repository.TaskRepository;

public class TaskManager {
    
    private final TaskRepository repository;

    public TaskManager(TaskRepository repository) {
        this.repository = repository;
    }
    
    public Task save(Task task) {
        return this.repository.save(task);
    }
    
    public List<Task> findAll() {
        return this.repository.findAll();
    }
    
    public Task findById(Long id) {
        return this.repository.find(id);
    }
}
