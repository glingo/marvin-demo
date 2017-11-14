package marvin.demo.bundle.game.resources.view.game.console;

import com.marvin.bundle.console.command.Command;
import com.marvin.bundle.console.mvc.view.Canvas;
import com.marvin.bundle.console.mvc.view.ConsoleView;
import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.component.mvc.model.Model;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import marvin.demo.bundle.game.model.Game;
import org.fusesource.jansi.Ansi;
import org.jline.keymap.KeyMap;
import org.jline.reader.Binding;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.Macro;
import org.jline.reader.Reference;
import org.jline.reader.Widget;
import org.jline.reader.impl.LineReaderImpl;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;
import org.jline.utils.InfoCmp;

public class GameView extends ConsoleView {
    
    Timer timer = new Timer();
    private int counter;
        
    public GameView(String name) {
        super(name);
    }
    
    @Override
    protected String getTitle(Handler<Command, Terminal> handler, Model model, Command request, Terminal response) throws Exception {
//        Optional<Game> optional = model.get("game", Game.class);
//        if (!optional.isPresent() || null == optional.get()) {
//            return "No game selected";
//        }
//        
//        Game game = optional.get();
//        return "Game " + game.getTitle() + game.getDescription();
        return "";
    }

    @Override
    protected String getBody(Handler<Command, Terminal> handler, Model model, Command request, Terminal writer) throws Exception {
        Optional<Game> optional = model.get("game", Game.class);
        if (!optional.isPresent() || null == optional.get()) {
            return "No game selected";
        }
        
        Game game = optional.get();
        game.setWidth(writer.getWidth() - 1);
        
//        Canvas canvas = new Canvas(1, 1, game.getHeight(), game.getWidth());
//        canvas.write(game.getLon(), game.getLat(), Objects.toString(this.counter, "0"), game.isRed() ? Ansi.Color.GREEN :  Ansi.Color.RED);
        AttributedStringBuilder builder = new AttributedStringBuilder();
        
        builder.append(Objects.toString(game.getHeight(), "0"))
                .append(" ").append(Objects.toString(game.getWidth(), "0"))
                .append(" ").append(Objects.toString(game.getTick(), "0"))
                .append(" (").append(Objects.toString(game.getLat(), "0"))
                .append(", ").append(Objects.toString(game.getLon(), "0"))
                .append(")")
                .append('\n');
        
        for (int h = 1; h <= game.getHeight(); h++) {
            for (int w = 1; w <= game.getWidth(); w++) {
                String c = " ";
//                builder.style(AttributedStyle.DEFAULT.background(AttributedStyle.BLUE));
                
                if (game.getLat() == h && game.getLon() == w) {
//                    builder.style(AttributedStyle.DEFAULT.background(game.isRed() ? AttributedStyle.RED : AttributedStyle.GREEN));
                    c = "0";
                }
                
                if(w == 1 ||  h == 1 || h == game.getHeight() || w == game.getWidth()) {
                    c = "X";
                }
                
                builder.append(c);
                
                if(w == game.getWidth()) {
                    builder.append('\n');
                }
            }
        }
//        builder.columnSplitLength(game.getWidth());
        builder.columnSplitLength(20);
        return builder.toAttributedString().toAnsi();
    }

    @Override
    public void render(Handler<Command, Terminal> handler, Map<String, Object> model, Command request, Terminal response) throws Exception {
//        while (++counter < 10) {
//            super.render(handler, model, request, response);
//        }
        
        Optional<Game> optional = new Model(model).get("game", Game.class);
        if (!optional.isPresent() || null == optional.get()) {
            return;
        }
        response.puts(InfoCmp.Capability.clear_screen);
        response.flush();
        super.render(handler, model, request, response);
        
        Game game = optional.get();
        
        LineReader reader = LineReaderBuilder.builder()
            .terminal(response)
            .build();

        reader.getWidgets().put("escape", () -> {
            game.setRunning(false);
            response.writer().println("Stop !!!!!!!");
            response.writer().flush();
            return true;
        });
        
        KeyMap<Binding> map = reader.getKeyMaps().getOrDefault("example", new KeyMap<>());
        map.bind(
            new Reference("escape"), KeyMap.esc()
        );
        reader.getKeyMaps().put("example", map);
        
        response.writer().write("Input the key event(Enter to complete): ");
        response.writer().flush();
        
        reader.readLine();
//        StringBuilder sb = new StringBuilder();
//        while (true) {
//            int c = ((LineReaderImpl) reader).readCharacter();
//            if (c == 10 || c == 13) break;
//            sb.append(new String(Character.toChars(c)));
//        }
//        response.writer().println(KeyMap.display(sb.toString()));
//        response.writer().flush();
        
        if (!game.isRunning()) {
            return;
        }
        
//        int c = ((LineReaderImpl) reader).readCharacter();
//        System.err.println(new String(Character.toChars(c)));
//        System.err.println(KeyMap.display(sb.toString()));
        Thread.sleep(1000);
        
        String command = "/game/show/".concat(game.getId().toString());
        handler.handle(new Command(command), response, false);
//        String command = "/game/show/".concat(game.getId().toString());
//        handler.handle(new Command(command), response, false);
    }
}
