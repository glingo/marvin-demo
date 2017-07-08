package marvin.demo.app;

import com.marvin.bundle.console.ConsoleApplication;
import com.marvin.bundle.console.ConsoleBundle;
import com.marvin.bundle.framework.Application;
import com.marvin.bundle.framework.FrameworkBundle;
import marvin.demo.bundle.todo.TodoBundle;
import com.marvin.component.kernel.bundle.Bundle;
import java.io.File;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import marvin.demo.bundle.game.GameBundle;

public class DemoApplication extends ConsoleApplication {

    public DemoApplication(String env, boolean debug) {
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

        Application.launch(DemoApplication.class, args);
    }

    @Override
    protected List<Bundle> registerBundles() {
        return Arrays.asList(
            // add framework bundle.
            new FrameworkBundle(),
//            new DebugBundle(),
            new ConsoleBundle(),
//            new ShellBundle(),
//            new MenuBundle(),

            new TodoBundle(),
            new GameBundle()
        );
    }
}
