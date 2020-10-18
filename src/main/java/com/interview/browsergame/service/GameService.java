package com.interview.browsergame.service;

import com.interview.browsergame.model.Game;
import com.interview.browsergame.model.LeaderBoard;
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

    private List<LeaderBoard> leaderBoardList = new ArrayList<>();

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public List<LeaderBoard> ranking() {

        List<Object[]> results = gameRepository.ranking();

        for (Object[] entry : results) {
            leaderBoardList.add(new LeaderBoard(playerService.findById((Long) entry[0]), (Long) entry[1]));
        }
        return leaderBoardList;
    }

    public List<LeaderBoard> rankingToday() {

        List<Object[]> results = gameRepository.rankingToday();

        for (Object[] entry : results) {
            leaderBoardList.add(new LeaderBoard(playerService.findById((Long) entry[0]), (Long) entry[1]));
        }
        return leaderBoardList;
    }
}
