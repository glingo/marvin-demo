package marvin.demo.app.bundles.test.controller;

import com.marvin.component.container.awareness.ContainerAware;
import com.marvin.component.kernel.dialog.Response;
import java.io.StringWriter;

public class TestController extends ContainerAware {

    public Response test() {
        Response response = new Response();
        StringWriter writer = new StringWriter();
        writer.append("\ntest.charger");
        response.setContent(writer.toString());
        return response;
    }
}
