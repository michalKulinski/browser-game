package com.interview.browsergame.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long playerId;

    private Long score;

    @CreationTimestamp
    private Timestamp timestamp;

    public Game(Long id, Long playerId, Long score, Timestamp timestamp) {
        this.id = id;
        this.playerId = playerId;
        this.score = score;
        this.timestamp = timestamp;
    }

    public Game() {
    }

    public Long getId() {
        return id;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public Long getScore() {
        return score;
    }

    public Timestamp getDate() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", playerId=" + playerId +
                ", score=" + score +
                ", timestamp=" + timestamp +
                '}';
    }
}
