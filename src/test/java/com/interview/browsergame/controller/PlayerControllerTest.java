package com.interview.browsergame.controller;

import com.interview.browsergame.model.Player;
import com.interview.browsergame.service.PlayerService;
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

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class PlayerControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private PlayerController playerController;

    @Mock
    private PlayerService playerService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(playerController).build();
    }

    @Test
    public void testFindAllPlayers() throws Exception {

        //given
        Player player1 = new Player(1L, "Adam", "Nowak");
        Player player2 = new Player(2L, "Ania", "Kowalska");

        String jsonResponse = ("[{\"id\":1,\"firstName\":\"Adam\",\"lastName\":\"Nowak\"},{\"id\":2,\"firstName\":\"Ania\",\"lastName\":\"Kowalska\"}]");

        when(playerService.findAll()).thenReturn(Arrays.asList(player1, player2));

        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/players")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(content().json(jsonResponse));

    }

    @Test
    public void testFindPlayerById() throws Exception {

        //given
        Player player1 = new Player(1L, "Adam", "Nowak");

        String jsonResponse = ("{id=1, firstName=Adam, lastName=Nowak}");

        when(playerService.findById(player1.getId())).thenReturn(player1);

        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/player/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(1)))
                .andExpect(jsonPath("$.firstName", Matchers.is("Adam")))
                .andExpect(jsonPath("$.lastName", Matchers.is("Nowak")))
                .andExpect(content().json(jsonResponse));

    }
}