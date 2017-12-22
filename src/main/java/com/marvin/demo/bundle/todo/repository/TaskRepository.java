package com.marvin.demo.bundle.todo.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.marvin.demo.bundle.todo.model.Task;

public class TaskRepository {
    
    private Map<Long, Task> tasks;

    public TaskRepository() {
        this.tasks = new HashMap<>();
    }
    
    public TaskRepository(Map<Long, Task> tasks) {
        this.tasks = tasks;
    }
    
    public Task save(Task task) {
        
        if (Objects.isNull(task.getId())) {
            task.setId(Integer.toUnsignedLong(this.tasks.size()));
        }
        
        return this.tasks.put(task.getId(), task);
    }
    
    public Task find(Long id) {
        return this.tasks.get(id);
    }
    
    public List<Task> findAll() {
        return new ArrayList<>(this.tasks.values());
    }
}
