package com.keyin.Game;

import com.keyin.Studio.Studio;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
    public ResponseEntity<Iterable<Game>> getAllGames(){
        return new ResponseEntity<>(gameService.getAllGamesInSystem(),HttpStatus.OK);
    }

    @PostMapping("/addStudioToGame/{studioId}/{gameId}")
    public ResponseEntity<String>addStudioToGame(@PathVariable Long gameId,@PathVariable Long studioId){
         gameService.addStudioToGame(gameId, studioId);
         return new ResponseEntity<>("Studio Has Been Added To Game :)",HttpStatus.OK);
    }

    @GetMapping("/getAllStudiosForGame/{gameId}")
    public ResponseEntity<Iterable<Studio>> getAllStudiosOfGame(@PathVariable Long gameId){
        return new ResponseEntity<>( gameService.getAllStudiosOfGame(gameId),HttpStatus.OK);
    }

    @GetMapping("/getAllGamesForStudio/{studioId}")
    public ResponseEntity< Iterable<Game>> getAllGamesOfStudio(@PathVariable Long studioId){
        return new ResponseEntity<>(gameService.getGamesOfStudio(studioId),HttpStatus.OK);
    }

    @GetMapping("/getGameById/{gameId}")
    public ResponseEntity<Game> getGameById(@PathVariable Long gameId){
        return new ResponseEntity<>(gameService.getGameById(gameId).orElse(null),HttpStatus.OK);
    }

    @GetMapping("/findGameByPlatformName")
    public ResponseEntity< Iterable<Game>> getGamesByPlatformName(@RequestParam String platformName){
        return new ResponseEntity<>(gameService.getGamesByPlatformName(platformName),HttpStatus.OK);
    }

}
