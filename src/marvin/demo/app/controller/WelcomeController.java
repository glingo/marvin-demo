package marvin.demo.app.controller;

import com.marvin.bundle.framework.controller.Controller;
import java.util.HashMap;
import java.util.Map;

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
    protected Object render(String name, Map context, String suffix) {
        context.put("kernel", get("kernel"));
        name = "marvin/demo/app/resources/view/" + name;
        return super.render(name, context, suffix);
    }
}
