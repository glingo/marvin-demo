package marvin.demo.bundle.game.resources.view.game;

import marvin.demo.bundle.todo.resources.view.todo.*;
import com.marvin.bundle.console.command.Command;
import com.marvin.bundle.console.mvc.view.ConsoleView;
import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.component.mvc.model.Model;
import java.io.OutputStream;

public class CreateView extends ConsoleView {

    public CreateView(String name) {
        super(name, 50, 50);
    }
    
    @Override
    protected String getTitle(Handler<Command, OutputStream> handler, Model model, Command request, OutputStream response) throws Exception {
        return "Create a Game :";
    }

    @Override
    protected String getBody(Handler<Command, OutputStream> handler, Model model, Command request, OutputStream response) throws Exception {
        spinner(response, 2000);
        String title = input("title", response, System.in, String.class);
        String description = input("description", response, System.in, String.class);
        spinner(response, 2000);
//        try {
            String command = "/games/create/".concat(title).concat("/").concat(description);
            handler.handle(new Command(command), response, false);
//        } catch(Exception exception) {
//            return "Création échouée";
//        }
        spinner(response, 2000);
        return "Création réussi";
    }
}
