package marvin.demo.app.resources.view.swing;

import com.marvin.bundle.console.command.Command;
import com.marvin.bundle.console.mvc.view.ConsoleView;
import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.bundle.swing.resources.view.SwingView;
import com.marvin.component.mvc.model.Model;
import java.util.Map;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import org.jline.terminal.Terminal;

public class HomeView extends SwingView {

    public HomeView(String name) {
        super(name);
    }

    @Override
    protected void prepare(Handler<Action, JFrame> handler, Model model, JFrame frame) throws Exception {
        frame.setJMenuBar(createMenu(new JMenuBar(), handler, frame));
    }
    
//    @Override
//    protected String getTitle(Handler<Command, Terminal> handler, Model model, Command request, Terminal response) throws Exception {
//        return "Index";
//    }

    
//    @Override
//    public void render(Handler<Command, Terminal> handler, Map<String, Object> model, Command request, Terminal response) throws Exception {
//        Model m = new Model(model);
//        response.writer().println(getTitle(handler, m, request, response));
//        response.writer().println(getBody(handler, m, request, response));
//        response.flush();
//    }
    
//    @Override
//    protected String getBody(Handler<Command, Terminal> handler, Model model, Command request, Terminal response) throws Exception {
//        new MenuView("menu").render(handler, model, request, response);
//        return "";
//    }
    
    private JMenuBar createMenu(JMenuBar menuBar, Handler<Action, JFrame> handler, JFrame frame) {
        menuBar.add(createUserMenu(handler, frame));
        menuBar.add(createDemoMenu(handler, frame));
        menuBar.add(createAddressBookMenu(handler, frame));
        menuBar.add(createGameMenu(handler, frame));
        menuBar.add(createTodosMenu(handler, frame));
        return menuBar;
    }
    
    private JMenu createDemoMenu(Handler<Action, JFrame> handler, JFrame frame) {
        JMenu menu              = new JMenu("Demo");
        JMenuItem home          = new JMenuItem(createAction("home_action", "/", handler, frame));
        JMenuItem view          = new JMenuItem(createAction("view_action", "/demo/view", handler, frame));
        JMenuItem model         = new JMenuItem(createAction("model_action", "/demo/model", handler, frame));
        JMenuItem modelandview  = new JMenuItem(createAction("model_and_view_action", "/demo/modelandview", handler, frame));
        JMenuItem modelmap      = new JMenuItem(createAction("model_as_map_action", "/demo/modelmap", handler, frame));
        
        menu.add(home);
        menu.add(view);
        menu.add(model);
        menu.add(modelandview);
        menu.add(modelmap);
        
        return menu;
    }
    
    private JMenu createUserMenu(Handler<Action, JFrame> handler, JFrame frame) {
        JMenu menu = new JMenu("User");
        JMenuItem login = new JMenuItem(createAction("login", "/login", handler, frame));
        menu.add(login);
        
        return menu;
    }
    
    private JMenu createAddressBookMenu(Handler<Action, JFrame> handler, JFrame frame) {
        JMenu menu = new JMenu("Address book");
        
        JMenuItem addressBook = new JMenuItem(createAction("persons", "/addressbook", handler, frame));
        menu.add(addressBook);
        
        return menu;
    }
    
    private JMenu createTodosMenu(Handler<Action, JFrame> handler, JFrame frame) {
        JMenu menu = new JMenu("Todos");
        
        JMenuItem todos = new JMenuItem(createAction("list", "/todos", handler, frame));
        menu.add(todos);
        
        return menu;
    }
    
    private JMenu createGameMenu(Handler<Action, JFrame> handler, JFrame frame) {
        JMenu menu = new JMenu("Game");
        
        JMenuItem games = new JMenuItem(createAction("games", "/game", handler, frame));
        menu.add(games);
        
        return menu;
    }
}
