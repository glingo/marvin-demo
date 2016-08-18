package marvin.demo.app.bundles.test.controller;

import com.marvin.component.container.awareness.ContainerAware;
import com.marvin.component.templating.Engine;
import com.marvin.component.templating.template.Template;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DefaultController extends ContainerAware {

    public void charger() {
        try {
            Map<String, Object> context = new HashMap<>();
            context.put("name", "Mitchell");
            
            Writer writer = this.get("print_writer", Writer.class);
            Engine engine = this.get("templating_engine", Engine.class);
            Template template = engine.getTemplate("com/marvin/bundle/framework/resources/view/base.html.view");
            
            template.evaluate(writer, context);
            
        } catch (Exception ex) {
            Logger.getLogger(DefaultController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
