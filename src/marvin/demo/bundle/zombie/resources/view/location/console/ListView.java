package marvin.demo.bundle.zombie.resources.view.zombie.console;

import com.marvin.bundle.console.command.Command;
import com.marvin.bundle.console.mvc.view.ConsoleView;
import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.component.mvc.model.Model;
import java.util.List;
import java.util.Optional;
import marvin.demo.bundle.zombie.model.Location;
import marvin.demo.bundle.zombie.model.World;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;

public class ListView extends ConsoleView {
    
    public ListView(String name) {
        super(name);
    }
    
    @Override
    protected String getTitle(Handler<Command, Terminal> handler, Model model, Command request, Terminal response) throws Exception {
        return "Locations :";
    }

    @Override
    protected String getBody(Handler<Command, Terminal> handler, Model model, Command request, Terminal terminal) throws Exception {
        Optional<List<Location>> locations = model.get("locations", List.class);
        AttributedStringBuilder builder = new AttributedStringBuilder()
                .style(AttributedStyle.DEFAULT.italic())
                .append("Liste des lieux : ")
                .append(AttributedString.NEWLINE);
        
        if (!locations.isPresent()) {
            builder
                .append(AttributedString.NEWLINE)
                .append("Aucun lieu créé")
                .append(AttributedString.NEWLINE);
            return builder.toAnsi(terminal);
        }
        
        locations.get().stream().forEach((location) -> {
            builder
                .append(location.toString())
                .append(AttributedString.NEWLINE);
        });
        
        return builder.toAnsi(terminal);
    }
}
