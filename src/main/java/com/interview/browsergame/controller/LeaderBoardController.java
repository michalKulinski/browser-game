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

    @GetMapping("/today")
    public List<LeaderBoard> leaderBoardToday() {
        return leaderBoardService.leaderBoardsToday();
    }

    @GetMapping("/weekly")
    public String leaderBoardThisWeek() {
        return "Leader Board";
    }

    @GetMapping("/yearly")
    public String leaderBoardThisYear() {
        return "Leader Board";
    }
}
