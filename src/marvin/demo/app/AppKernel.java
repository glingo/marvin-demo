package marvin.demo.app;

import com.marvin.bundle.console.ConsoleBundle;
import com.marvin.component.kernel.Kernel;
//import com.marvin.bundle.debug.DebugBundle;
import com.marvin.bundle.framework.FrameworkBundle;
//import com.marvin.bundle.menu.MenuBundle;
import com.marvin.component.kernel.bundle.Bundle;
import marvin.demo.bundle.todo.TodoBundle;

public class AppKernel extends Kernel {

    public AppKernel(String environment, boolean debug) {
        super(environment, debug);
    }
    
    @Override
    protected Bundle[] registerBundles() {
        return new Bundle[]{
            // add framework bundle.
            new FrameworkBundle(),
//            new DebugBundle(),
            new ConsoleBundle(),
//            new ShellBundle(),
//            new MenuBundle(),
            
            new TodoBundle(),
        };
    }
}
