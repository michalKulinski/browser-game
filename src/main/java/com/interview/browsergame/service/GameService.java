package com.interview.browsergame.service;

import com.interview.browsergame.model.Game;
import com.interview.browsergame.model.LeaderBoard;
import com.interview.browsergame.model.Player;
import com.interview.browsergame.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlayerService playerService;

    private List<LeaderBoard> leaderBoardList;

    public Game createGame(Game game) throws Exception {
        if (playerService.findById(game.getPlayerId()) != null) {
            return gameRepository.save(game);
        } else {
            throw new Exception("Player not found");
        }
    }

    public List<LeaderBoard> ranking() {
        leaderBoardList = new ArrayList<>();
        List<Object[]> results = gameRepository.ranking();

        for (Object[] entry : results) {
            leaderBoardList.add(new LeaderBoard(playerService.findById((Long) entry[0]), (Long) entry[1]));
        }
        return leaderBoardList;
    }

    public List<LeaderBoard> rankingDaily() {
        leaderBoardList = new ArrayList<>();
        List<Object[]> results = gameRepository.rankingDaily();

        for (Object[] entry : results) {
            leaderBoardList.add(new LeaderBoard(playerService.findById((Long) entry[0]), (Long) entry[1]));
        }
        return leaderBoardList;
    }

    public List<LeaderBoard> rankingWeekly() {
        leaderBoardList = new ArrayList<>();
        List<Object[]> results = gameRepository.rankingWeekly();

        for (Object[] entry : results) {
            leaderBoardList.add(new LeaderBoard(playerService.findById((Long) entry[0]), (Long) entry[1]));
        }
        return leaderBoardList;
    }

    public List<LeaderBoard> rankingYearly() {
        leaderBoardList = new ArrayList<>();
        List<Object[]> results = gameRepository.rankingYearly();

        for (Object[] entry : results) {
                leaderBoardList.add(new LeaderBoard(playerService.findById((Long) entry[0]), (Long) entry[1]));
        }
        return leaderBoardList;
    }
}
