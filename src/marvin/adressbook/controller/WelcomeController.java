package marvin.adressbook.controller;

import com.marvin.bundle.framework.controller.tomove.Controller;
import java.util.HashMap;
import java.util.Map;
import marvin.adressbook.repository.PersonRepository;

public class WelcomeController extends Controller {

    public void welcome() {
        Map context = new HashMap();
        PersonRepository repo = PersonRepository.getInstance();
        context.put("persons", repo.getAll());
        this.render("marvin/demo/app/bundles/adressbook/resources/view/welcome", context, "fxml");
    }
}
