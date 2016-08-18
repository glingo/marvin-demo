package marvin.demo.app.bundles.test.controller;

import com.marvin.component.container.awareness.ContainerAware;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestController extends ContainerAware {

    public void test() {
        try {
            Writer writer = this.get("print_writer", Writer.class);
            writer.append("\ntest.charger");
        } catch (IOException ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
