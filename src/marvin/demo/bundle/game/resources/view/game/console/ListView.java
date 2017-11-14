package marvin.demo.bundle.game.resources.view.game.console;

import com.marvin.bundle.console.command.Command;
import com.marvin.bundle.console.mvc.view.ConsoleView;
import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.component.mvc.model.Model;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import marvin.demo.bundle.game.model.Game;
import org.jline.terminal.Terminal;

public class ListView extends ConsoleView  {

    public ListView(String name) {
        super(name);
    }

    @Override
    protected String getTitle(Handler<Command, Terminal> handler, Model model, Command request, Terminal response) throws Exception {
        return "Games";
    }

    @Override
    protected String getBody(Handler<Command, Terminal> handler, Model model, Command request, Terminal writer) throws Exception {
        Optional<List<Game>> games = model.get("games", List.class);
        
        String body = "No Game yet ...";
        
        if (games.isPresent() && !games.get().isEmpty()) {
            body = games.get().stream().map((task) -> {
                return "* ".concat(task.getId().toString()).concat(" ").concat(task.getTitle()).concat(" : ").concat(task.getDescription());
            }).collect(Collectors.joining("|\n|")).concat("|\n");
        }
        
        return body;
    }
    
}
