package com.marvin.demo.app;

import com.marvin.bundle.console.ConsoleBundle;
import com.marvin.bundle.framework.FrameworkBundle;
import com.marvin.bundle.swing.SwingBundle;
import com.marvin.bundle.web.WebBundle;
import com.marvin.component.kernel.bundle.Bundle;
import java.util.Arrays;
import java.util.List;

public class Application extends com.marvin.bundle.framework.Application {

    public Application(String env, boolean debug) {
        super(env, debug);
    }
    
    public static void main(String[] args) {
        Application.launch(Application.class, args);
    }

    @Override
    protected List<Bundle> registerBundles() {
        return Arrays.asList(
            // add framework bundle.
            new FrameworkBundle(),
            new ConsoleBundle(),
            new SwingBundle(),
            new WebBundle()
        );
    }
}
