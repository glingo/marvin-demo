package marvin.demo.app.bundles.test.controller;

import com.marvin.component.container.awareness.ContainerAware;
import com.marvin.component.kernel.dialog.Response;
import com.marvin.component.templating.Engine;
import com.marvin.component.templating.template.Template;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DefaultController extends ContainerAware {

    public Response charger() {
        Response response = new Response();
        try {
            Map<String, Object> context = new HashMap<>();
            context.put("name", "Mitchell");
            
            StringWriter writer = new StringWriter();
            Engine engine = this.get("templating_engine", Engine.class);
            Template template = engine.getTemplate("com/marvin/bundle/framework/resources/view/base.html.view");
            template.evaluate(writer, context);
            response.setContent(writer.toString());
        } catch (Exception ex) {
            Logger.getLogger(DefaultController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }
    
    public Response hello(String name) {
        Response response = new Response();
        try {
            Map<String, Object> context = new HashMap<>();
            context.put("name", name);
            
            StringWriter writer = new StringWriter();
            Engine engine = this.get("templating_engine", Engine.class);
            Template template = engine.getTemplate("com/marvin/bundle/framework/resources/view/hello.html.view");
            template.evaluate(writer, context);
            response.setContent(writer.toString());
        } catch (Exception ex) {
            Logger.getLogger(DefaultController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }
}
