package com.interview.browsergame.service;

import com.interview.browsergame.model.LeaderBoard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaderBoardService {

    @Autowired
    GameService gameService;

    @Autowired
    PlayerService playerService;

    public List<LeaderBoard> leaderBoards() {
        return gameService.ranking();
    }

    public List<LeaderBoard> leaderBoardsDaily() {
        return gameService.rankingDaily();
    }

    public List<LeaderBoard> leaderBoardsWeekly() {
        return gameService.rankingWeekly();
    }

    public List<LeaderBoard> leaderBoardsYearly() {
        return gameService.rankingYearly();
    }

}
