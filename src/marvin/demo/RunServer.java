package marvin.demo;

import com.marvin.bundle.framework.console.Console;
import com.marvin.bundle.framework.server.Server;
import com.marvin.component.kernel.Kernel;
import marvin.demo.app.AppKernel;


/**
 *
 * @author Dr.Who
 */
public class RunServer {
    
    public static void main(String[] args) throws Exception {
        Kernel kernel = new AppKernel(true);
        Server server = new Server(kernel, 80, 81);
        server.start();
    }
}
