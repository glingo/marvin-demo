package marvin.demo.bundle.game.business;

import java.util.List;
import marvin.demo.bundle.game.model.Game;
import marvin.demo.bundle.game.repository.GameRepository;

public class GameManager {
    
    private final GameRepository repository;

    public GameManager(GameRepository repository) {
        this.repository = repository;
    }
    
    public Game save(Game task) {
        return this.repository.save(task);
    }
    
    public List<Game> findAll() {
        return this.repository.findAll();
    }
}
