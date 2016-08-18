package marvin.demo;

import com.marvin.bundle.framework.console.Console;
import com.marvin.component.kernel.Kernel;
import marvin.demo.app.AppKernel;

public class RunConsole {
    
    public static void main(String[] args) throws Exception {
        Kernel kernel   = new AppKernel(true);
        Console console = new Console(kernel);
        console.start();
    }
}
