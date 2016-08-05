package marvin.demo.app.bundles.test.controller;

//import com.marvin.old.routing.mapping.Route;

import com.marvin.component.container.awareness.ContainerAware;
import com.marvin.component.templating.Engine;
import com.marvin.component.templating.template.Template;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DefaultController extends ContainerAware {

//    @Route(name = "default.home", path = "/")//, reponse="ressources/view/nav.view.twig"
    public void charger() {
        try {
//            writer.println("default.charger");
            
            
            
            
            
            Map<String, Object> context = new HashMap<>();
            context.put("name", "Mitchell");
            
            PrintWriter writer = this.get("print_writer", PrintWriter.class);
            Engine engine = this.get("templating_engine", Engine.class);
            Template template = engine.getTemplate("com/marvin/bundle/framework/resources/view/base.html.view");
            
            template.evaluate(writer, context);
            
        } catch (Exception ex) {
            Logger.getLogger(DefaultController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
