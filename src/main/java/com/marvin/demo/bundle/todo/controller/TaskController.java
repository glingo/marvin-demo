package com.marvin.demo.bundle.todo.controller;

import com.marvin.bundle.framework.mvc.ModelAndView;
import java.util.List;
import com.marvin.demo.bundle.todo.business.TaskManager;
import com.marvin.demo.bundle.todo.model.Task;

public class TaskController {
    
    private final TaskManager manager;

    public TaskController(TaskManager manager) {
        this.manager = manager;
    }
    
    public ModelAndView list() {
        return ModelAndView.builder().view("Todo:todo:list")
                .model("todos", this.manager.findAll())
                .build();
    }
    
    public ModelAndView edit(String id) {
        Long arg = Long.valueOf(id);
        Task task = this.manager.findById(arg);
        return ModelAndView.builder().model("task", task).view(form()).build();
    }
    
    public ModelAndView create(String name, String description) {
        this.manager.save(new Task(name, description));
        return list();
    }
    
    public String form() {
        return "Todo:todo:create";
    }
}
