package marvin.adressbook.controller;

import com.marvin.bundle.framework.controller.tomove.Controller;
import java.util.HashMap;
import java.util.Map;
import marvin.adressbook.model.Person;

public class PersonController extends Controller {

    public void createPersonAction() {
        Map context = new HashMap();
//        PersonRepository repo = PersonRepository.getInstance();
        context.put("person", new Person());
        this.render("marvin/demo/app/bundles/adressbook/resources/view/person/create", context, "fxml");
    }
}
