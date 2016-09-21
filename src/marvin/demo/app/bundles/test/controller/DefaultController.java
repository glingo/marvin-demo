package marvin.demo.app.bundles.test.controller;

import com.marvin.bundle.framework.controller.Controller;
import com.marvin.component.dialog.Response;
import java.util.HashMap;
import java.util.Map;

public class DefaultController extends Controller {
    
    public Response hello(String name) {
        Map<String, Object> context = new HashMap<>();
        context.put("name", name);
        
        return render("com/marvin/bundle/framework/resources/view/base.html.view", context);

    }
}
