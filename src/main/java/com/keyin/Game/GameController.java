package com.keyin.Game;

import com.keyin.Studio.Studio;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class GameController {

    @Autowired
    private GameService gameService;



    @PostMapping("/addGame")
    public void addGame(Game game){
        gameService.addGame(game);
    }

    @GetMapping("/getAllGames")
    public Iterable<Game> getAllGames(){
        return gameService.getAllGamesInSystem();
    }

    @PostMapping("/addStudioToGame/{studioId}/{gameId}")
    public void addStudioToGame(@PathVariable Long gameId,@PathVariable Long studioId){
        gameService.addStudioToGame(gameId, studioId);
    }

    @GetMapping("/getAllStudiosForGame/{gameId}")
    public Iterable<Studio> getAllStudiosOfGame(@PathVariable Long gameId){
        return gameService.getAllStudiosOfGame(gameId);
    }

    @GetMapping("/getAllGamesForStudio/{studioId}")
    public Iterable<Game> getAllGamesOfStudio(@PathVariable Long studioId){
        return gameService.getGamesOfStudio(studioId);
    }

}
