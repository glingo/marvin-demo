package com.marvin.demo.app;

import com.marvin.bundle.framework.Application;
import com.marvin.bundle.framework.FrameworkBundle;
import com.marvin.bundle.swing.SwingApplication;
import com.marvin.bundle.swing.SwingBundle;
import com.marvin.demo.bundle.todo.TodoBundle;
import com.marvin.component.kernel.bundle.Bundle;
import java.util.Arrays;
import java.util.List;
import com.marvin.demo.bundle.game.GameBundle;

public class DemoSwingApplication extends SwingApplication {

    public DemoSwingApplication(String env, boolean debug) {
        super(env, debug);
    }
    
    public static void main(String[] args) {
        Application.launch(DemoSwingApplication.class, args);
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