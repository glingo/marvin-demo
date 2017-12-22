package com.marvin.demo.bundle.zombie.model;

import java.util.List;

public class World {
    
    private long timestamp = 0;
    
    private int width = 100;
    
    private int height = 100;
    
    private List<Location> locations;
    
    private List<Survivor> survivors;

    public World() {
        
    }

    public World(int width, int height, List<Location> locations, List<Survivor> survivors) {
        this.width = width;
        this.height = height;
        this.locations = locations;
        this.survivors = survivors;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public List<Survivor> getSurvivors() {
        return survivors;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public void setSurvivors(List<Survivor> survivors) {
        this.survivors = survivors;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
