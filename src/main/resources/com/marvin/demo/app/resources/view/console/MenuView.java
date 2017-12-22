package com.marvin.demo.app.resources.view.console;

import com.marvin.bundle.console.command.Command;
import com.marvin.bundle.console.mvc.view.Canvas;
import com.marvin.bundle.console.mvc.view.ConsoleView;
import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.bundle.framework.mvc.model.Model;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.util.Map;
import java.util.Objects;
import org.fusesource.jansi.Ansi;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;

public class MenuView extends ConsoleView {
    
    private final String arrow = " -> ";

    public MenuView(String name) {
        super(name);
    }

    @Override
    protected String getTitle(Handler<Command, Terminal> handler, Model model, Command request, Terminal response) throws Exception {
        return "MENU PRINCIPAL";
    }
 
    @Override
    protected String getBody(Handler<Command, Terminal> handler, Model model, Command request, Terminal writer) throws Exception {
        return new AttributedStringBuilder()
            .style(AttributedStyle.DEFAULT.background(AttributedStyle.BLUE))
            .append("/".concat(this.arrow).concat("Index\n"))
            .append("/model".concat(this.arrow).concat("Controller that return a Model Object\n"))
            .append("/view".concat(this.arrow).concat("Controller that return a View Object\n"))
            .append("/modelAndView".concat(this.arrow).concat("Controller that return a ModelAndView Object\n"))
            .append("\t/todos".concat(this.arrow).concat("List tasks\n"))
            .append("\t/todos/form".concat(this.arrow).concat("Show the form\n"))
            .append("\t/todos/create/{title}/{description}".concat(this.arrow).concat("Create a Task with the given title and description\n"))
            .style(AttributedStyle.DEFAULT).toAnsi();
    }

//    @Override
//    public void render(Handler<Command, Terminal> handler, Map<String, Object> model, Command request, Terminal response) throws Exception {
//        Model m = new Model(model);
//        response.writer().println("MENU PRINCIPAL");
//        response.writer().println(getBody(handler, m, request, response));
//        response.flush();
//    }
}
