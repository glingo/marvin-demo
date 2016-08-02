package marvin.demo;

import com.marvin.bundle.framework.console.Console;
import com.marvin.component.kernel.Kernel;
import marvin.demo.app.AppKernel;

/**
 *
 * @author Dr.Who
 */
public class MyTest {

    public MyTest() {
        
        Kernel kernel = new AppKernel(true);
        
        Console console = new Console(kernel);
        console.start();

//        Server server = new Server(kernel, 46, 47);
//        server.start();
        
//        Application httpserver = new HTTPServer(kernel);
//        httpserver.start();
        
//        try {
//            kernel.boot();
//            Container c = (Container) kernel.getContainer().get("container");
//            IService service = (IService) c.get("test.service.c");
//            service.sayHello();
            
//            Kernel a = (Kernel) c.get("kernel");
//            System.out.println(c);
//            System.out.println(a);
//        } catch (Exception ex) {
//            Logger.getLogger(MyTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
        // instrumentation (profiling)
//        Instrumentation inst;
    }
}
