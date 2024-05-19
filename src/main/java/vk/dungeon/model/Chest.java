package vk.dungeon.model;

import lombok.Getter;
import vk.dungeon.model.type.ChestRarity;

import java.util.Random;

@Getter
public class Chest {
    private ChestRarity rarity;
    private int value;

    public void setRarity(ChestRarity rarity) {
        this.rarity = rarity;
        setValue();
    }

    private void setValue() {
        Random random = new Random();
        switch (rarity) {
            case COMMON -> value = random.nextInt(1, 10);
            case RARE -> value = random.nextInt(11, 20);
            case LEGENDARY -> value = random.nextInt(21, 30);
            default -> value = 0;
        }
    }
}
