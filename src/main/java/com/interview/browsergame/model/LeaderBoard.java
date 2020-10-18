package com.interview.browsergame.model;

public class LeaderBoard {

    private Player player;

    private Long score;

    public LeaderBoard(Player player, Long score) {
        this.player = player;
        this.score = score;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}
