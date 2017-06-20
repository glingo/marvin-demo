package marvin.demo.bundle.game.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import marvin.demo.bundle.game.model.Game;

public class GameRepository {
    
    private Map<Long, Game> games;

    public GameRepository() {
        this.games = new HashMap<>();
    }
    
    public GameRepository(Map<Long, Game> games) {
        this.games = games;
    }
    
    public Game save(Game task) {
        
        if (Objects.isNull(task.getId())) {
            task.setId(Integer.toUnsignedLong(this.games.size()));
        }
        
        return this.games.put(task.getId(), task);
    }
    
    public Game find(Long id) {
        return this.games.get(id);
    }
    
    public List<Game> findAll() {
        return new ArrayList<>(this.games.values());
    }
}
