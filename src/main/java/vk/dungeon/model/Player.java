package vk.dungeon.model;

import lombok.Getter;

@Getter
public class Player {

    private int score;

    public Player() {
        this.score = 0;
    }

    public void addPoints(int points) {
        score = score + points;
    }
}
