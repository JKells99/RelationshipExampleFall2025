package com.keyin.Game;

import com.keyin.Studio.Studio;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class GameController {

    @Autowired
    private GameService gameService;



    @PostMapping("/addGame")
    public ResponseEntity<Game> addGame(@RequestBody Game game){

       return new ResponseEntity<>(gameService.addGame(game), HttpStatus.CREATED);
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

    @GetMapping("/getGameById/{gameId}")
    public Game getGameById(@PathVariable Long gameId){
        return gameService.getGameById(gameId).orElse(null);
    }

}
