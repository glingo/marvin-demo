package com.marvin.demo.bundle.game.resources.view.game.console;

import com.marvin.bundle.console.command.Command;
import com.marvin.bundle.console.mvc.view.Canvas;
import com.marvin.bundle.console.mvc.view.ConsoleView;
import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.bundle.framework.mvc.model.Model;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.util.Objects;
import org.fusesource.jansi.Ansi;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;

public class CreateView extends ConsoleView {

    public CreateView(String name) {
        super(name);
    }
    
    @Override
    protected String getTitle(Handler<Command, Terminal> handler, Model model, Command request, Terminal response) throws Exception {
        return "Create a Game :";
    }

    @Override
    protected String getBody(Handler<Command, Terminal> handler, Model model, Command request, Terminal response) throws Exception {
        LineReader reader = LineReaderBuilder.builder().terminal(response).build();
        String title = reader.readLine("title");
        String description = reader.readLine("description");
        String command = "/games/create/".concat(title).concat("/").concat(description);
        handler.handle(new Command(command), response, false);
        return "Création réussi";
//        spinner(writer, 2000);
//        String title = input("title", writer, System.in, String.class);
//        spinner(writer, 0, 2000);
//        String description = input("description", writer, System.in, String.class);
//        String command = "/games/create/".concat(title).concat("/").concat(description);
//        handler.handle(new Command(command), System.out, false);
//        spinner(writer, 2000);

//        line("Création réussi", writer);
    }
}
