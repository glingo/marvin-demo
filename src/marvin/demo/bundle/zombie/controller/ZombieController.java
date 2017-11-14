package marvin.demo.bundle.zombie.controller;

import com.marvin.component.mvc.ModelAndView;
import java.util.Arrays;
import marvin.demo.bundle.zombie.model.Location;
import marvin.demo.bundle.zombie.model.World;

public class ZombieController {
    
    public ZombieController() {
    }
    
    public ModelAndView index() {
        Location home = new Location("Home", 15, 15);
        Location hangar = new Location("hangar", 30, 30);
        
        World world = new World();
        world.setLocations(Arrays.asList(home, hangar));
        
        return ModelAndView.builder()
                .model("world", world)
                .view("Zombie:zombie:index")
                .build();
    }
}
