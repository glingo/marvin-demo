package marvin.demo.bundle.todo.controller;

import com.marvin.component.mvc.ModelAndView;
import com.marvin.component.mvc.model.Model;
import java.util.ArrayList;
import java.util.List;
import marvin.demo.bundle.todo.model.Task;

public class TodoController {
    
    
    public ModelAndView list() {
        
        List<Task> todos = new ArrayList<>();
        
        todos.add(new Task("Tache 1", "Ma premiere tache"));
        todos.add(new Task("Tache 2", "Ma deuxieme tache"));
        
        Model model = new Model();
        model.put("todos", todos);
        
        return ModelAndView.builder().view("todo/list").model(model).build();
    }
    
    public ModelAndView create() {
        
        return ModelAndView.builder().view("todo/create").build();
    }
}
