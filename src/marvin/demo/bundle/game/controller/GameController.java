package marvin.demo.bundle.game.controller;

import com.marvin.component.mvc.ModelAndView;
import marvin.demo.bundle.game.business.GameManager;
import marvin.demo.bundle.game.model.Game;

public class GameController {
    
    private final GameManager manager;

    public GameController(GameManager manager) {
        this.manager = manager;
    }
    
    public ModelAndView list() {
        return ModelAndView.builder().view("Game:game:list")
                .model("games", this.manager.findAll())
                .build();
    }
    
    public ModelAndView create(String name, String description) {
        this.manager.save(new Game(name, description));
        return list();
    }
    
    public ModelAndView form() {
        return ModelAndView.builder().view("Game:game:create").build();
    }
}
