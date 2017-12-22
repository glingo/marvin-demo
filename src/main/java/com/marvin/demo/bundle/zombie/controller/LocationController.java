package com.marvin.demo.bundle.zombie.controller;

import com.marvin.bundle.framework.mvc.ModelAndView;
import java.util.Arrays;
import com.marvin.demo.bundle.zombie.business.LocationManager;
import com.marvin.demo.bundle.zombie.model.Location;
import com.marvin.demo.bundle.zombie.model.World;

public class LocationController {
    
    private final LocationManager manager;
    
    public LocationController(LocationManager manager) {
        this.manager = manager;
    }
    
    public ModelAndView list() {
        Location home = new Location("Home", 15, 15);
        Location hangar = new Location("hangar", 30, 30);
        
        World world = new World();
        world.setLocations(Arrays.asList(home, hangar));
        
        return ModelAndView.builder()
                .model("world", world)
                .view("Zombie:location:list")
                .build();
    }
    
    public ModelAndView create(String name, int lon, int lat) {
        Location location = new Location(name, lon, lat);
        
        this.manager.save(location);
        return ModelAndView.builder()
                .view("Zombie:zombie:index")
                .build();
    }
}
