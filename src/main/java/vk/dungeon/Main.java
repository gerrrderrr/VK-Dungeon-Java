package vk.dungeon;

import vk.dungeon.model.Dungeon;
import vk.dungeon.model.Player;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Dungeon dungeon = new Dungeon("src/main/resources/dungeon" + random.nextInt(1, 5) + ".json");
        Game game = new Game(new Player(), dungeon);
        try {
            game.start();
        } catch (InterruptedException e) {
            System.out.println("There was some problem in this game. Try again.");
        }
    }
}