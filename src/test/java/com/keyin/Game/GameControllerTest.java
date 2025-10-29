// java
package com.keyin.Game;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest( GameController.class)
public class GameControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private GameService gameService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testGetGameById_ReturnsGame() throws Exception {
        Game mockGame = new Game();
        mockGame.setId(1L);
        mockGame.setName("Elden Ring");

        when(gameService.getGameById(1L)).thenReturn(Optional.of(mockGame));

        mockMvc.perform(get("/getGameById/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Elden Ring"));
    }

    @Test
    void testCreateGame() throws Exception {
        Game newGame = new Game();
        newGame.setName("Zelda");

        Game savedGame = new Game();
        savedGame.setId(1L);
        savedGame.setName("Zelda");
        when(gameService.addGame(any(Game.class))).thenReturn(savedGame);
        mockMvc.perform(post("/addGame")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newGame)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Zelda"));
    }


    @Test
    void getAllGames() {
    }

    @Test
    void addStudioToGame() {
    }
}
