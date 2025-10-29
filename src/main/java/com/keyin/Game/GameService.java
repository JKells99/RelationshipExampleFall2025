package com.keyin.Game;

import com.keyin.Studio.Studio;
import com.keyin.Studio.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {


    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private StudioRepository studioRepository;

    public Game addGame(Game game){
       return gameRepository.save(game);
    }
    public void removeGame(Game game){
        gameRepository.delete(game);
    }

    public Iterable<Game> getAllGamesInSystem(){
        return gameRepository.findAll();
    }

    public void addStudioToGame(Long gameId, Long studioId){
        Optional<Game> game = gameRepository.findById(gameId);
        Optional<Studio> studio = studioRepository.findById(studioId);

        if(game.isPresent() && studio.isPresent()){
            game.get().addStudio(studio.get());
            gameRepository.save(game.get());
        }

    }

    public Iterable<Studio> getAllStudiosOfGame(Long gameId){
        Optional<Game> game = gameRepository.findById(gameId);


        return game.<Iterable<Studio>>map(Game::getListOfStudios).orElse(null);


    }

    public List<Game> getGamesOfStudio(Long studioId){
        Optional<Studio> studio = studioRepository.findById(studioId);
        if (studio.isPresent()) {
            return gameRepository.findByListOfStudiosContaining(studio.get());
        }
        return null;

    }
    public Optional<Game> getGameById(Long gameId){
        return gameRepository.findById(gameId);
    }

    public List<Game> getGamesByPlatformName(String platformName){
        return gameRepository.findGamesByGameDetail_PlatformName(platformName);
    }




}
