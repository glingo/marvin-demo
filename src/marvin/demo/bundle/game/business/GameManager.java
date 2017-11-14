package marvin.demo.bundle.game.business;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import marvin.demo.bundle.game.model.Game;
import marvin.demo.bundle.game.repository.GameRepository;

public class GameManager {
    
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private final GameRepository repository;

    public GameManager(GameRepository repository) {
        this.repository = repository;
    }
    
    public Game save(Game task) {
        return this.repository.save(task);
    }
    
    public Game findById(Long id) {
        return this.repository.find(id);
    }
    
    public List<Game> findAll() {
        return this.repository.findAll();
    }
    
    public void stop(Game game) {
        executor.shutdown();
        game.setRunning(true);
    }
    
    public void run(Game game) {
        executor.scheduleWithFixedDelay(() -> {
               game.update();
               this.repository.save(game);
//           }, 1, 1000/60, TimeUnit.MILLISECONDS);
           }, 1, 1, TimeUnit.SECONDS);
        game.setRunning(true);
    }
}
