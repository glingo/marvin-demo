package com.marvin.demo.bundle.zombie.resources.view.zombie.console;

import com.marvin.bundle.console.command.Command;
import com.marvin.bundle.console.mvc.view.ConsoleView;
import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.bundle.framework.mvc.model.Model;
import java.util.Optional;
import com.marvin.demo.bundle.zombie.model.Location;
import com.marvin.demo.bundle.zombie.model.World;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
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
        Optional<World> world = model.get("world", World.class);
        AttributedStringBuilder builder = new AttributedStringBuilder()
                .style(AttributedStyle.DEFAULT.italic())
                .append("Bienvenue dans Zombie")
                .append(AttributedString.NEWLINE);
        
        if (!world.isPresent()) {
            builder
                .append(AttributedString.NEWLINE)
                .append("Aucun monde créé")
                .append(AttributedString.NEWLINE);
            return builder.toAnsi(terminal);
        }
        
        world.get().getLocations().stream().forEach((location) -> {
            builder
                .append(location.toString())
                .append(AttributedString.NEWLINE);
        });
        
        return builder.toAnsi(terminal);
    }
}
