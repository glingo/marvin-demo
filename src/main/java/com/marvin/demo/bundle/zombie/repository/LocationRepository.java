package com.marvin.demo.bundle.zombie.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.marvin.demo.bundle.todo.model.Task;
import com.marvin.demo.bundle.zombie.model.Location;

public class LocationRepository {
    
    private Map<Long, Location> values;

    public LocationRepository() {
        this.values = new HashMap<>();
    }
    
    public LocationRepository(Map<Long, Location> values) {
        this.values = values;
    }
    
    public Location save(Location value) {
        
        if (Objects.isNull(value.getId())) {
            value.setId(Integer.toUnsignedLong(this.values.size()));
        }
        
        return this.values.put(value.getId(), value);
    }
    
    public Location find(Long id) {
        return this.values.get(id);
    }
    
    public List<Location> findAll() {
        return new ArrayList<>(this.values.values());
    }
}
