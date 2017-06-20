package marvin.demo.bundle.game.resources.view.game;

import com.marvin.bundle.console.command.Command;
import com.marvin.bundle.console.mvc.view.ConsoleView;
import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.component.mvc.model.Model;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import marvin.demo.bundle.game.model.Game;

public class ListView extends ConsoleView  {

    public ListView(String name) {
        super(name, 130, 130);
    }

    @Override
    protected String getTitle(Handler<Command, OutputStream> handler, Model model, Command request, OutputStream response) throws Exception {
        return "Games :";
    }

    @Override
    protected String getBody(Handler<Command, OutputStream> handler, Model model, Command request, OutputStream response) throws Exception {
        Optional<List<Game>> games = model.get("games", List.class);
        
        String body = "No Game yet ...";
        
        if (games.isPresent() && !games.get().isEmpty()) {
            body = games.get().stream().map((task) -> {
                return "* ".concat(task.getTitle()).concat(" : ").concat(task.getDescription());
            }).collect(Collectors.joining("|\n|")).concat("|\n");
        }
        
        return body;
    }
    
}
