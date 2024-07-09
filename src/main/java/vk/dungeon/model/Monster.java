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
                strength = random.nextInt(MonsterType.COMMON.getOrigin(), MonsterType.COMMON.getBound());
                damage = MonsterType.COMMON.getDamage();
            }
            case CHAMPION -> {
                strength = random.nextInt(MonsterType.CHAMPION.getOrigin(), MonsterType.CHAMPION.getBound());
                damage = MonsterType.CHAMPION.getDamage();
            }
            case BOSS -> {
                strength = random.nextInt(MonsterType.BOSS.getOrigin(), MonsterType.BOSS.getBound());
                damage = MonsterType.BOSS.getDamage();;
            }
            case LEGENDARY -> {
                strength = random.nextInt(MonsterType.LEGENDARY.getOrigin(), MonsterType.LEGENDARY.getBound());
                damage = MonsterType.LEGENDARY.getDamage();;
            }
            default -> {
                strength = 0;
                damage = 0;
            }
        }
    }

    public void reduceStrength() {
        strength -= damage;
    }
}
