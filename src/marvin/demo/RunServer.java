package marvin.demo;

import com.marvin.component.kernel.Kernel;
import com.marvin.component.server.Server;
import marvin.demo.app.AppKernel;

public class RunServer {
    
    public static void main(String[] args) throws Exception {
        Kernel kernel = new AppKernel(true);
        Server server = new Server(kernel, 80, 81);
        server.start();
    }
}
