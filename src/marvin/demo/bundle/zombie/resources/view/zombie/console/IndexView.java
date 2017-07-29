package marvin.demo.bundle.zombie.resources.view.zombie.console;

import com.marvin.bundle.console.command.Command;
import com.marvin.bundle.console.mvc.view.ConsoleView;
import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.component.mvc.model.Model;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import marvin.demo.bundle.todo.model.Task;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;

public class IndexView extends ConsoleView {
    
    public IndexView(String name) {
        super(name);
    }
     @Override
    protected String getTitle(Handler<Command, Terminal> handler, Model model, Command request, Terminal response) throws Exception {
        return "Zombie Index :";
    }

    @Override
    protected String getBody(Handler<Command, Terminal> handler, Model model, Command request, Terminal terminal) throws Exception {
        return new AttributedStringBuilder()
                .style(AttributedStyle.DEFAULT.italic())
                .append("Bienvenue dans Zombie")
                .toAnsi(terminal);
    }
}
