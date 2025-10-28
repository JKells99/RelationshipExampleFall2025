package com.keyin.Game;

import com.keyin.Studio.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository <Game, Long>{

    List<Game> findByListOfStudiosContaining(Studio studio);
}
