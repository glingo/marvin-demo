package com.marvin.demo.bundle.game.controller;

import com.marvin.bundle.framework.mvc.ModelAndView;
import com.marvin.demo.bundle.game.business.GameManager;
import com.marvin.demo.bundle.game.model.Game;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jline.utils.InfoCmp;

public class GameController {
    
    private final GameManager manager;

    public GameController(GameManager manager) {
        this.manager = manager;
    }
    
    public String run(String id) {
        Game game = this.manager.findById(Long.valueOf(id));
        this.manager.run(game);
        return "Game:game:list";
    }
    
    public ModelAndView show(String id) {
        Game game = this.manager.findById(Long.valueOf(id));
        return ModelAndView.builder().view("Game:game:game")
                .model("game", game)
                .build();
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
