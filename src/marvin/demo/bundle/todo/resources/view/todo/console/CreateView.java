package marvin.demo.bundle.todo.resources.view.todo.console;

import com.marvin.bundle.console.command.Command;
import com.marvin.bundle.console.mvc.view.ConsoleView;
import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.component.mvc.model.Model;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import marvin.demo.bundle.todo.model.Task;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
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
    protected String getBody(Handler<Command, Terminal> handler, Model model, Command request, Terminal response) throws Exception {
        Optional<Task> current = model.get("task", Task.class);
        
        LineReader reader = LineReaderBuilder.builder().terminal(response).build();
        
        if (!current.isPresent()) {
            String title = reader.readLine("title");
            String description = reader.readLine("description");
            
            String command = "/todos/create/".concat(title).concat("/").concat(description);
//            String command = "/todos/create/".concat("hello").concat("/").concat("world");
            handler.handle(new Command(command), response, false);
//            spinner(writer, 0, 2000);
        }
        
        return "Création réussi";
    }
}
