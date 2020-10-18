package com.interview.browsergame.repository;

import com.interview.browsergame.model.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Long> {

    Game save(Game game);

    List<Game> findByPlayerId(Long id);

    @Query("SELECT playerId, SUM(score) as scoreSum FROM Game GROUP BY playerId ORDER BY scoreSum DESC")
    List<Object[]> ranking();

    @Query("SELECT playerId, SUM(score) as scoreSum FROM Game WHERE timestamp>=CURRENT_DATE GROUP BY playerId ORDER BY scoreSum DESC")
    List<Object[]> rankingToday();

}
