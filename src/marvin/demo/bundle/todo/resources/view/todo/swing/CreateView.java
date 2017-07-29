package marvin.demo.bundle.todo.resources.view.todo.swing;

import com.marvin.bundle.console.command.Command;
import com.marvin.bundle.console.mvc.view.ConsoleView;
import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.component.mvc.model.Model;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.util.Objects;
import java.util.Optional;
import marvin.demo.bundle.todo.model.Task;
import org.jline.terminal.Terminal;

public class CreateView extends ConsoleView {

    public CreateView(String name) {
        super(name);
    }
    
    @Override
    protected String getTitle(Handler<Command, Terminal> handler, Model model, Command request, Terminal response) throws Exception {
        Optional<Task> current = model.get("task", Task.class);
        
        if (!current.isPresent()) {
            return "Create a Task :";
        }
        
        return "Edit a Task ".concat(Objects.toString(current.get().getId())).concat(" :");
    }

    @Override
    protected String getBody(Handler<Command, Terminal> handler, Model model, Command request, Terminal writer) throws Exception {
//        Optional<Task> current = model.get("task", Task.class);
//        spinner(writer, 2000);
//        
//        if (!current.isPresent()) {
//            String title = input("title", writer, System.in, String.class);
//            String description = input("description", writer, System.in, String.class);
//            
//            String command = "/todos/create/".concat(title).concat("/").concat(description);
//            handler.handle(new Command(command), System.out, false);
//            spinner(writer, 0, 2000);
//            return "Création réussi";
//        }
        
        return "";
    }
}
