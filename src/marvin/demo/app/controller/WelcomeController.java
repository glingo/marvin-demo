package marvin.demo.app.controller;

import com.marvin.bundle.framework.controller.Controller;
import com.marvin.component.kernel.dialog.Response;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cdi305
 */
public class WelcomeController extends Controller {

    public void welcomeAction(String type) {
        this.render("welcome", new HashMap<>(), type);
    }

    public void welcomeHTMLAction() {
        this.render("welcome", new HashMap<>(), "html");
    }

    public void welcomeTEXTAction() {
        this.render("welcome", new HashMap<>(), "txt");
    }

    public void welcomeFXMLAction() {
        this.render("welcome", new HashMap<>(), "fxml");
    }

    @Override
    protected Response render(String name, Map context, String suffix) {
        context.put("kernel", get("kernel"));
        name = "marvin/demo/app/resources/view/" + name;
        return super.render(name, context, suffix);
    }
}
