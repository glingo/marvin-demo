package com.marvin.demo.app.resources.view.console;

import com.marvin.bundle.console.command.Command;
import com.marvin.bundle.console.mvc.view.ConsoleView;
import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.bundle.framework.mvc.model.Model;
import java.util.Map;
import org.jline.terminal.Terminal;

public class HomeView extends ConsoleView {

    public HomeView(String name) {
        super(name);
    }

    @Override
    protected String getTitle(Handler<Command, Terminal> handler, Model model, Command request, Terminal response) throws Exception {
        return "Index";
    }
    
//    @Override
//    public void render(Handler<Command, Terminal> handler, Map<String, Object> model, Command request, Terminal response) throws Exception {
//        Model m = new Model(model);
//        response.writer().println(getTitle(handler, m, request, response));
//        response.writer().println(getBody(handler, m, request, response));
//        response.flush();
//    }
    
    @Override
    protected String getBody(Handler<Command, Terminal> handler, Model model, Command request, Terminal response) throws Exception {
        new MenuView("menu").render(handler, model, request, response);
        return "";
    }
}
