package marvin.demo.app;

import com.marvin.bundle.console.ConsoleApplication;
import com.marvin.bundle.console.ConsoleBundle;
import com.marvin.bundle.framework.Application;
import com.marvin.bundle.framework.FrameworkBundle;
import com.marvin.bundle.swing.SwingApplication;
import com.marvin.bundle.swing.SwingBundle;
import marvin.demo.bundle.todo.TodoBundle;
import com.marvin.component.kernel.bundle.Bundle;
import java.io.File;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import marvin.demo.bundle.game.GameBundle;

public class DemoSwingApplication extends SwingApplication {

    public DemoSwingApplication(String env, boolean debug) {
        super(env, debug);
    }
    
    public static void main(String[] args) {
        System.out.println(File.separator);
        System.out.println(FileSystems.getDefault().getSeparator());
        
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.*");
        System.out.println(matcher.matches(Paths.get("a", "b")));
        System.out.println(matcher.matches(Paths.get("a.a", "b")));
        System.out.println(matcher.matches(Paths.get("a.a")));

        for (FileStore store: FileSystems.getDefault().getFileStores()) {
            System.out.println(store);
        }

        Application.launch(DemoSwingApplication.class, args);
    }

    @Override
    protected JMenuBar createMenu(JMenuBar menuBar) {
        menuBar.add(createUserMenu());
        menuBar.add(createDemoMenu());
        menuBar.add(createAddressBookMenu());
        menuBar.add(createGameMenu());
        return menuBar;
    }
    
    private JMenu createDemoMenu() {
        JMenu menu              = new JMenu("Demo");
        JMenuItem home          = new JMenuItem(createAction("home_action", "/"));
        JMenuItem view          = new JMenuItem(createAction("view_action", "/demo/view"));
        JMenuItem model         = new JMenuItem(createAction("model_action", "/demo/model"));
        JMenuItem modelandview  = new JMenuItem(createAction("model_and_view_action", "/demo/modelandview"));
        JMenuItem modelmap      = new JMenuItem(createAction("model_as_map_action", "/demo/modelmap"));
        
        menu.add(home);
        menu.add(view);
        menu.add(model);
        menu.add(modelandview);
        menu.add(modelmap);
        
        return menu;
    }
    
    private JMenu createUserMenu() {
        JMenu menu = new JMenu("User");
        JMenuItem login = new JMenuItem(createAction("login", "/login"));
        menu.add(login);
        
        return menu;
    }
    
    private JMenu createAddressBookMenu() {
        JMenu menu = new JMenu("Address book");
        
        JMenuItem addressBook = new JMenuItem(createAction("persons", "/addressbook/"));
        menu.add(addressBook);
        
        return menu;
    }
    
    private JMenu createGameMenu() {
        JMenu menu = new JMenu("Game");
        
        JMenuItem games = new JMenuItem(createAction("games", "/game/"));
        menu.add(games);
        
        return menu;
    }
    
    @Override
    protected List<Bundle> registerBundles() {
        return Arrays.asList(
            // add framework bundle.
            new FrameworkBundle(),
//            new DebugBundle(),
            new SwingBundle(),
//            new ShellBundle(),
//            new MenuBundle(),
            
            new TodoBundle(),
            new GameBundle()
        );
    }

}
