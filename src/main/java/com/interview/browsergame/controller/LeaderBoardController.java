package com.interview.browsergame.controller;

import com.interview.browsergame.model.LeaderBoard;
import com.interview.browsergame.service.LeaderBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/leaderboard")
public class LeaderBoardController {

    @Autowired
    LeaderBoardService leaderBoardService;

    @GetMapping
    public List<LeaderBoard> leaderBoard() {
        return leaderBoardService.leaderBoards();
    }

    @GetMapping("/daily")
    public List<LeaderBoard> leaderBoardDaily() {
        return leaderBoardService.leaderBoardsDaily();
    }

    @GetMapping("/weekly")
    public List<LeaderBoard> leaderBoardWeekly() {
        return leaderBoardService.leaderBoardsWeekly();
    }

    @GetMapping("/yearly")
    public List<LeaderBoard> leaderBoardYearly() {
        return leaderBoardService.leaderBoardsYearly();
    }
}
