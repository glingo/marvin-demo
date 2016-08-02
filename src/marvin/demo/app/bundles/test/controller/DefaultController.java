package marvin.demo.app.bundles.test.controller;

//import com.marvin.old.routing.mapping.Route;

import com.marvin.component.container.awareness.ContainerAware;
import java.io.PrintWriter;


public class DefaultController extends ContainerAware {

//    @Route(name = "default.home", path = "/")//, reponse="ressources/view/nav.view.twig"
    public void charger() {
        PrintWriter writer = this.get("print_writer", PrintWriter.class);
        writer.println("default.charger");
    }
}
