package marvin.demo.bundle.zombie.controller;

import com.marvin.component.mvc.ModelAndView;
import marvin.demo.bundle.zombie.model.Location;
import marvin.demo.bundle.zombie.model.World;

public class ZombieController {
    
    public ZombieController() {
    }
    
    public ModelAndView index() {
        Location home = new Location("Home", 15, 15);
        
        Wrold world = new World();
        return ModelAndView.builder().view("Zombie:zombie:index")
                .build();
    }
}
