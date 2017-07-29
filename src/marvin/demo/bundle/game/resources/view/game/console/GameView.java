package marvin.demo.bundle.game.resources.view.game.console;

import com.marvin.bundle.console.command.Command;
import com.marvin.bundle.console.mvc.view.Canvas;
import com.marvin.bundle.console.mvc.view.ConsoleView;
import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.component.mvc.model.Model;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import marvin.demo.bundle.game.model.Game;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.jline.terminal.Terminal;

public class GameView extends ConsoleView {
    
    private Canvas canvas = new Canvas(1, 1, 30, 120);
    Timer timer = new Timer();
        
    public GameView(String name) {
        super(name);
    }
    
    @Override
    protected String getTitle(Handler<Command, Terminal> handler, Model model, Command request, Terminal response) throws Exception {
        return "Game " + model.getOrDefault("game-title", "null");
    }

    @Override
    protected String getBody(Handler<Command, Terminal> handler, Model model, Command request, Terminal writer) throws Exception {
        canvas.write(10, 10, " ", System.currentTimeMillis() % 2 == 0 ? Ansi.Color.GREEN :  Ansi.Color.RED);
        return canvas.getAnsi().toString();
    }
//
//    @Override
//    public void render(Handler<Command, OutputStream> handler, Map<String, Object> model, Command request, OutputStream response) throws Exception {
//        Model m = new Model(model);
//        OutputStream stream = new BufferedOutputStream(AnsiConsole.wrapOutputStream(response));
////        canvas.write(10, 10, " ", Ansi.Color.GREEN);
////        super.render(handler, model, request, response);
////        Model m = new Model(model);
////        Optional<Game> game = m.get("game", Game.class);
////        canvas.render(stream);
//        canvas.getAnsi().eraseScreen();
//        canvas.write(10, 10, " ", System.currentTimeMillis() % 2 == 0 ? Ansi.Color.GREEN :  Ansi.Color.RED);
//        canvas.render(stream);
//        stream.flush();
//        
////        timer.purge();
////        timer.schedule(new TimerTask() {
////            @Override
////            public void run() {
////                try {
////                    render(handler, model, request, response);
////                } catch (Exception ex) {
////                }
////            }
////        }, 1000 / 60);
//    }
}
