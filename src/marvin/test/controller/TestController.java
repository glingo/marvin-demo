package marvin.test.controller;

import com.marvin.component.container.awareness.ContainerAware;
import java.io.StringWriter;

public class TestController extends ContainerAware {

    public Object test() {
        StringWriter writer = new StringWriter();
        writer.append("\ntest.charger");
        return writer.toString();
    }
}
