package marvin.demo.bundle.zombie.business;

import java.util.List;
import marvin.demo.bundle.todo.model.Task;
import marvin.demo.bundle.todo.repository.TaskRepository;
import marvin.demo.bundle.zombie.model.Location;
import marvin.demo.bundle.zombie.repository.LocationRepository;

public class LocationManager {
    
    private final LocationRepository repository;

    public LocationManager(LocationRepository repository) {
        this.repository = repository;
    }
    
    public Location save(Location location) {
        return this.repository.save(location);
    }
    
    public List<Location> findAll() {
        return this.repository.findAll();
    }
    
    public Location findById(Long id) {
        return this.repository.find(id);
    }
}
