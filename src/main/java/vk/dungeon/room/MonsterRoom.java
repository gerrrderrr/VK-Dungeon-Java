package vk.dungeon.room;

import lombok.Setter;
import vk.dungeon.model.Monster;

import java.util.Random;

@Setter
public class MonsterRoom extends Room {

    private Monster monster;
    private final Random random = new Random();

    public int startAFight() throws InterruptedException {
        if (isVisited()) {
            return 0;
        }
        System.out.printf("You see him looking at you!%nYou realize that it is a %s monster.%n" +
                "Monster strength is %d.%n", monster.getType().name().toLowerCase(), monster.getStrength());
        requestForRandom();

        int random = getRandom();

        while (random <= monster.getStrength()) {
            System.out.printf("%n%nMonster strength was %d and God of random gave you %d.%n", monster.getStrength(), random);
            monster.reduceStrength();
            random = getRandom();
            System.out.printf("Now Monster became weaker. His strength is %d!%nLets test your luck again!%n", monster.getStrength());
            requestForRandom();
        }
        System.out.printf("%n%nGod of random gave you %d and you've won %s points!%n", random, monster.getStrength());
        Thread.sleep(1000);
        setVisited(true);
        return Math.max(monster.getStrength(), 0);
    }

    private void requestForRandom() throws InterruptedException {
        System.out.print("SENDING REQUEST TO GOD OF RANDOM");
        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            Thread.sleep(1000);
        }
    }

    private int getRandom() {
        int bound = monster.getStrength();
        return random.nextInt(bound * 2);
    }
}
