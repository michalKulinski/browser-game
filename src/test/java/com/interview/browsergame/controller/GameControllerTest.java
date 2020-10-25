package com.interview.browsergame.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.interview.browsergame.model.Game;
import com.interview.browsergame.service.GameService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Timestamp;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class GameControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private GameController gameController;

    @Mock
    private GameService gameService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(gameController).build();
    }

    @Test
    public void playGameTest() throws Exception {

        //given
        Game game = new Game(1L, 2L, 235L, new Timestamp(System.currentTimeMillis()));

        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/api/playgame")
                .content(convertObjectToJsonString(game))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private String convertObjectToJsonString(Game game) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(game);
    }
}