package marvin.demo.app;

import com.marvin.bundle.console.ConsoleApplication;
import com.marvin.bundle.console.ConsoleBundle;
import com.marvin.bundle.framework.Application;
import com.marvin.bundle.framework.FrameworkBundle;
import marvin.demo.bundle.todo.TodoBundle;
import com.marvin.component.kernel.bundle.Bundle;
import java.util.Arrays;
import java.util.List;
import marvin.demo.bundle.game.GameBundle;

public class DemoApplication extends ConsoleApplication {

    public DemoApplication(String env, boolean debug) {
        super(env, debug);
    }
    
    public static void main(String[] args) {
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
