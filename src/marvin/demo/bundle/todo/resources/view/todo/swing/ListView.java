package marvin.demo.bundle.todo.resources.view.todo.swing;

import com.marvin.bundle.console.command.Command;
import com.marvin.bundle.console.mvc.view.ConsoleView;
import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.component.mvc.model.Model;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import marvin.demo.bundle.todo.model.Task;
import org.jline.terminal.Terminal;

public class ListView extends ConsoleView  {

    public ListView(String name) {
        super(name);
    }

    @Override
    protected String getTitle(Handler<Command, Terminal> handler, Model model, Command request, Terminal response) throws Exception {
        return "Todos :";
    }

    @Override
    protected String getBody(Handler<Command, Terminal> handler, Model model, Command request, Terminal writer) throws Exception {
        Optional<List<Task>> tasks = model.get("todos", List.class);
        
        if (!tasks.isPresent() || tasks.get().isEmpty()) {
            return"No Task yet ...";
        }
        
        return tasks.get().stream().map((task) -> {
                return Objects.toString(task.getId()).concat(") ").concat(task.getTitle()).concat(" : ").concat(task.getDescription());
            }).collect(Collectors.joining("|\n|")).concat("|\n");
    }
    
}
