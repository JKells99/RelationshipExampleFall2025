package com.keyin.Game;

import com.keyin.GameDetail.GameDetail;
import com.keyin.Studio.Studio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany
    private List<Studio> listOfStudios = new ArrayList<>();


    // using CascadeType all will allow this to save automatically with the game with no extra code
    @OneToOne(cascade = CascadeType.ALL)
    private GameDetail gameDetail;



    public void addStudio(Studio studio){
        listOfStudios.add(studio);
    }
    public void removeStudio(Studio studio){
        listOfStudios.remove(studio);
    }



}
