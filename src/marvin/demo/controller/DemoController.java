package marvin.demo.controller;

import com.marvin.bundle.framework.handler.subscriber.ViewResolverHandlerSubscriber;
import com.marvin.bundle.framework.mvc.view.IView;
import com.marvin.bundle.framework.mvc.model.Model;
import com.marvin.bundle.framework.mvc.ModelAndView;
import com.marvin.bundle.framework.mvc.view.View;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class DemoController {

    private static final Logger LOG = Logger.getLogger(DemoController.class.getName());
    
    public String index() {
        LOG.info("DemoController::index");
        return "home";
    }
    
    public Model model() {
        LOG.info("DemoController::model");
        Model model = new Model();
        return model;
    }
    
    public Map modelMap() {
        LOG.info("DemoController::modelMap");
        Map model = new HashMap<>();
        model.put(ViewResolverHandlerSubscriber.VIEW_PARAMETER, "home");
        return model;
    }
    
    public ModelAndView modelAndView() {
        LOG.info("DemoController::modelAndView");
        ModelAndView mav = new ModelAndView("home");
        
        mav.setModel(new HashMap<>());
        
        return mav;
    }
    
    public IView view() {
        LOG.info("DemoController::view");
        IView view = new View() {
            @Override
            public void render(HashMap model, Object request, Object response) {
                LOG.info("View::render");
            }
        };
        return view;
    }
    
}
