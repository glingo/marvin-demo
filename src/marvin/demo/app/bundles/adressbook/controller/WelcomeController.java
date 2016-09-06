package marvin.demo.app.bundles.adressbook.controller;

import com.marvin.bundle.framework.controller.Controller;
import java.util.HashMap;
import java.util.Map;
import marvin.demo.app.bundles.adressbook.repository.PersonRepository;

public class WelcomeController extends Controller {

    public void welcome() {
        Map context = new HashMap();
        PersonRepository repo = PersonRepository.getInstance();
        context.put("persons", repo.getAll());
        this.render("marvin/demo/app/bundles/adressbook/resources/view/welcome", context, "fxml");
    }
}
