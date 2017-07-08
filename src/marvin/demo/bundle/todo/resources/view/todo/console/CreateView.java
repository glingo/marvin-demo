package marvin.demo.bundle.todo.resources.view.todo.console;

import com.marvin.bundle.console.command.Command;
import com.marvin.bundle.console.mvc.view.ConsoleView;
import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.component.mvc.model.Model;
import java.io.OutputStream;
import java.util.Objects;
import java.util.Optional;
import marvin.demo.bundle.todo.model.Task;

public class CreateView extends ConsoleView {

    public CreateView(String name) {
        super(name, 50, 50);
    }
    
    @Override
    protected String getTitle(Handler<Command, OutputStream> handler, Model model, Command request, OutputStream response) throws Exception {
        Optional<Task> current = model.get("task", Task.class);
        
        if (!current.isPresent()) {
            return "Create a Task :";
        }
        
        return "Edit a Task ".concat(Objects.toString(current.get().getId())).concat(" :");
    }

    @Override
    protected String getBody(Handler<Command, OutputStream> handler, Model model, Command request, OutputStream response) throws Exception {
        Optional<Task> current = model.get("task", Task.class);
        spinner(response, 2000);
        String title = input("title", response, System.in, String.class);
        String description = input("description", response, System.in, String.class);
        
        if (!current.isPresent()) {
            
        }
        spinner(response, 2000);
//        try {
            String command = "/todos/create/".concat(title).concat("/").concat(description);
            handler.handle(new Command(command), response, false);
//        } catch(Exception exception) {
//            return "Création échouée";
//        }
        spinner(response, 2000);
        return "Création réussi";
    }
}
