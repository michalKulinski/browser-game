package com.interview.browsergame.controller;

import com.interview.browsergame.model.Game;
import com.interview.browsergame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping("/playgame")
    public Game playGame(@RequestBody Game game) {
        return gameService.createGame(game);
    }

}
