package marvin.demo.app.bundles.test.controller;

import com.marvin.component.container.awareness.ContainerAware;
import java.io.PrintWriter;

public class TestController extends ContainerAware {

    public void test() {
        PrintWriter writer = this.get("print_writer", PrintWriter.class);
        writer.println("test.charger");
    }
}
