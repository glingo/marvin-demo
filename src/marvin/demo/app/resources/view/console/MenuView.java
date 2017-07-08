package marvin.demo.app.resources.view.console;

import com.marvin.bundle.console.command.Command;
import com.marvin.bundle.console.mvc.view.ConsoleView;
import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.component.mvc.model.Model;
import java.io.OutputStream;

public class MenuView extends ConsoleView {
    
    private final String arrow = " -> ";

    public MenuView(String name) {
        super(name, 180, 180);
    }

    @Override
    protected String getTitle(Handler<Command, OutputStream> handler, Model model, Command request, OutputStream response) throws Exception {
        return "MENU PRINCIPAL";
    }

    @Override
    protected String getBody(Handler<Command, OutputStream> handler, Model model, Command request, OutputStream response) throws Exception {
        return "/".concat(this.arrow).concat("Index").concat("\n")
        .concat("/model").concat(this.arrow).concat("Controller that return a Model Object").concat("\n")
        .concat("/view").concat(this.arrow).concat("Controller that return a View Object").concat("\n")
        .concat("/modelAndView").concat(this.arrow).concat("Controller that return a ModelAndView Object").concat("\n")
        .concat("\t/todos").concat(this.arrow).concat("List tasks").concat("\n")
        .concat("\t/todos/form").concat(this.arrow).concat("Show the form").concat("\n")
        .concat("\t/todos/create/{title}/{description}").concat(this.arrow).concat("Create a Task with the given title and description").concat("\n");
    }
}
