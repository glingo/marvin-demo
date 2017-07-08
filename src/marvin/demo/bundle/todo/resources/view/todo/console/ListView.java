package marvin.demo.bundle.todo.resources.view.todo.console;

import com.marvin.bundle.console.command.Command;
import com.marvin.bundle.console.mvc.view.ConsoleView;
import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.component.mvc.model.Model;
import java.io.OutputStream;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import marvin.demo.bundle.todo.model.Task;

public class ListView extends ConsoleView  {

    public ListView(String name) {
        super(name, 130, 130);
    }

    @Override
    protected String getTitle(Handler<Command, OutputStream> handler, Model model, Command request, OutputStream response) throws Exception {
        return "Todos :";
    }

    @Override
    protected String getBody(Handler<Command, OutputStream> handler, Model model, Command request, OutputStream response) throws Exception {
        Optional<List<Task>> tasks = model.get("todos", List.class);
        
        String body = "No Task yet ...";
        
        if (tasks.isPresent() && !tasks.get().isEmpty()) {
            body = tasks.get().stream().map((task) -> {
                return Objects.toString(task.getId()).concat(") ").concat(task.getTitle()).concat(" : ").concat(task.getDescription());
            }).collect(Collectors.joining("|\n|")).concat("|\n");
        }
        
        return body;
    }
    
}
