package com.interview.browsergame.service;

import com.interview.browsergame.model.LeaderBoard;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LeaderBoardServiceTest {

    @InjectMocks
    private LeaderBoardService leaderBoardService;

    @Mock
    GameService gameService;

    @Mock
    PlayerService playerService;

    @Before
    public void setUp() {

    }

    @Test
    public void leaderBoardsTest() throws Exception {

        //given
        List<LeaderBoard> leaderBoards = new ArrayList<>();
        when(gameService.ranking()).thenReturn(leaderBoards);

        //when
        leaderBoardService.leaderBoards();

        //then
        verify(gameService, times(1)).ranking();
    }

    @Test
    public void dailyLeaderBoardTest() throws Exception {

        //given
        List<LeaderBoard> dailyLeaderBoards = new ArrayList<>();
        when(gameService.rankingDaily()).thenReturn(dailyLeaderBoards);

        //when
        leaderBoardService.leaderBoardsDaily();

        //then
        verify(gameService, times(1)).rankingDaily();
    }

    @Test
    public void weeklyLeaderBoardTest() throws Exception {

        //given
        List<LeaderBoard> weeklyLeaderBoards = new ArrayList<>();
        when(gameService.rankingWeekly()).thenReturn(weeklyLeaderBoards);

        //when
        leaderBoardService.leaderBoardsWeekly();

        //then
        verify(gameService, times(1)).rankingWeekly();
    }

    @Test
    public void yearlyLeaderBoardTest() throws Exception {

        //given
        List<LeaderBoard> yearlyLeaderBoards = new ArrayList<>();
        when(gameService.rankingYearly()).thenReturn(yearlyLeaderBoards);

        //when
        leaderBoardService.leaderBoardsYearly();

        //then
        verify(gameService, times(1)).rankingYearly();
    }


}