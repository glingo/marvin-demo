package marvin.demo.app.controller;

import com.marvin.bundle.framework.mvc.Handler;
import com.marvin.component.mvc.ModelAndView;
import com.marvin.bundle.framework.mvc.controller.Controller;
import com.marvin.bundle.framework.subscriber.ViewSubscriber;
import com.marvin.component.mvc.model.Model;
import com.marvin.component.mvc.view.View;
import com.marvin.component.mvc.view.ViewInterface;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class DefaultController extends Controller {

    private static final Logger LOG = Logger.getLogger(DefaultController.class.getName());
    
    public String index() {
        LOG.info("DefaultController::index");
        return "::home";
    }
    
    public Model model() {
        LOG.info("DefaultController::model");
        Model model = new Model();
        return model;
    }
    
    public Map modelMap() {
        LOG.info("DefaultController::modelMap");
        Map model = new HashMap<>();
        model.put(ViewSubscriber.VIEW_PARAMETER, "::home");
        return model;
    }
    
    public ModelAndView modelAndView() {
        LOG.info("DefaultController::modelAndView");
        ModelAndView mav = new ModelAndView("::home");
        
        mav.setModel(new HashMap<>());
        
        return mav;
    }
    
    public ViewInterface view() {
        LOG.info("DefaultController::view");
        ViewInterface view = new View("dummy") {
            @Override
            public void render(Handler handler, Map model, Object request, Object response) {
                LOG.info("View::render");
            }

            @Override
            public void load() throws Exception {
                LOG.info("View::load");
            }
        };
        return view;
    }
}
