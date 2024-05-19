package vk.dungeon.model;

import lombok.Getter;
import vk.dungeon.model.type.MonsterType;

import java.util.Random;

public class Monster {
    @Getter
    private MonsterType type;
    @Getter
    private int strength;
    private int damage;

    public void setType(MonsterType type) {
        this.type = type;
        setCharacteristics();
    }

    private void setCharacteristics() {
        Random random = new Random();
        switch (type) {
            case COMMON -> {
                strength = random.nextInt(10, 15);
                damage = 1;
            }
            case CHAMPION -> {
                strength = random.nextInt(16, 20);
                damage = 2;
            }
            case BOSS -> {
                strength = random.nextInt(21, 25);
                damage = 3;
            }
            case LEGENDARY -> {
                strength = random.nextInt(26, 30);
                damage = 4;
            }
            default -> {
                strength = 0;
                damage = 0;
            }
        }
    }

    public void reduceStrength() {
        strength = strength - damage;
    }
}
