package marvin.demo.app.resources.view.console;

import com.marvin.bundle.console.command.Command;
import com.marvin.bundle.console.mvc.view.ConsoleView;
import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.component.mvc.model.Model;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class HomeView extends ConsoleView {

    public HomeView(String name) {
        super(name, 180, 180);
    }

    @Override
    protected String getTitle(Handler<Command, OutputStream> handler, Model model, Command request, OutputStream response) {
        return "Index";
    }

    @Override
    protected String getBody(Handler<Command, OutputStream> handler, Model model, Command request, OutputStream response) throws Exception {
        OutputStream stream = new ByteArrayOutputStream();
        importView(new MenuView("menu"), handler, model, request, stream);
        stream.flush();
        spinner(response, 1000);
        return stream.toString();
    }
}
