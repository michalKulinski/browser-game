package com.interview.browsergame.repository;

import com.interview.browsergame.model.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Long> {

    String queryAll = "SELECT playerId, SUM(score) as scoreSum FROM Game GROUP BY playerId ORDER BY scoreSum DESC";
    String queryDaily = "SELECT playerId, SUM(score) as scoreSum FROM Game WHERE timestamp>=CURRENT_DATE GROUP BY playerId " +
            "ORDER BY scoreSum DESC";
    String queryWeekly = "SELECT playerId, SUM(score) as scoreSum FROM Game WHERE timestamp <= CURRENT_TIMESTAMP " +
            "AND timestamp > DATEADD(day, - DAY_OF_WEEK(current_date-1), current_date) GROUP BY playerId ORDER BY scoreSum DESC";
    String queryYearly = "SELECT playerId, SUM(score) as scoreSum FROM Game WHERE timestamp <= CURRENT_TIMESTAMP " +
            "AND timestamp > DATEADD(day, - DAY_OF_YEAR(current_date-1), current_date) GROUP BY playerId ORDER BY scoreSum DESC";

    Game save(Game game);

    List<Game> findByPlayerId(Long id);

    @Query(queryAll)
    List<Object[]> ranking();

    @Query(queryDaily)
    List<Object[]> rankingToday();

    @Query(queryWeekly)
    List<Object[]> rankingWeek();

    @Query(queryYearly)
    List<Object[]> rankingYearly();

}
