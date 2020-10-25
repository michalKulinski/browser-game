package com.interview.browsergame.service;

import com.interview.browsergame.model.Game;
import com.interview.browsergame.model.LeaderBoard;
import com.interview.browsergame.model.Player;
import com.interview.browsergame.repository.GameRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    @InjectMocks
    private GameService gameService;

    @Mock
    GameRepository gameRepository;

    @Mock
    PlayerService playerService;

    private List<LeaderBoard> leaderBoardList;

    private List<Object[]> sqlResults;

    @Before
    public void setUp() {
        sqlResults = new ArrayList<>();
        Object[] array1 = {1L, 235L};
        Object[] array2 = {2L, 655L};
        sqlResults.add(array1);
        sqlResults.add(array2);

        Player player = new Player(1L, "Adam", "Nowak");
        Player player2 = new Player(2L, "Anna", "Kowalska");

        leaderBoardList = new ArrayList<>();
        leaderBoardList.add(new LeaderBoard(player, 235L));
        leaderBoardList.add(new LeaderBoard(player2, 655L));
    }

    @Test
    public void createGameTest() throws Exception {

        //given
        Game game = new Game(1L, 2L, 235L, new Timestamp(System.currentTimeMillis()));
        Player player = new Player(2L, "Anna", "Kowalska");

        when(playerService.findById(game.getPlayerId())).thenReturn(player);

        //when
        gameService.createGame(game);

        //then
        verify(playerService, times(1)).findById(game.getPlayerId());
        verify(gameRepository, times(1)).save(game);
    }

    @Test(expected = Exception.class)
    public void createGameTestIfPlayerNotFound() throws Exception {

        //given
        Game game = new Game(1L, 2L, 235L, new Timestamp(System.currentTimeMillis()));

        when(playerService.findById(game.getPlayerId())).thenThrow(Exception.class);

        //when
        //then
        gameService.createGame(game);
    }

    @Test
    public void rankingTest() throws Exception {

        //given

        when(gameRepository.ranking()).thenReturn(sqlResults);

        //when
        gameService.ranking();

        //then
        verify(playerService, times(1)).findById(1L);
        verify(playerService, times(1)).findById(2L);
        assertEquals(leaderBoardList.size(), gameService.ranking().size());

    }

    @Test
    public void dailyRankingTest() throws Exception {

        //given
        when(gameRepository.rankingDaily()).thenReturn(sqlResults);

        //when
        gameService.rankingDaily();

        //then
        verify(playerService, times(1)).findById(1L);
        verify(playerService, times(1)).findById(2L);
        assertEquals(leaderBoardList.size(), gameService.rankingDaily().size());

    }

    @Test
    public void weeklyRankingTest() throws Exception {

        //given
        when(gameRepository.rankingWeekly()).thenReturn(sqlResults);

        //when
        gameService.rankingWeekly();

        //then
        verify(playerService, times(1)).findById(1L);
        verify(playerService, times(1)).findById(2L);
        assertEquals(leaderBoardList.size(), gameService.rankingWeekly().size());

    }

    @Test
    public void yearlyRankingTest() throws Exception {

        //given
        when(gameRepository.rankingYearly()).thenReturn(sqlResults);

        //when
        gameService.rankingYearly();

        //then
        verify(playerService, times(1)).findById(1L);
        verify(playerService, times(1)).findById(2L);
        assertEquals(leaderBoardList.size(), gameService.rankingYearly().size());

    }

}