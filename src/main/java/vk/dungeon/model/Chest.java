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
        value = switch (rarity) {
            case COMMON -> random.nextInt(ChestRarity.COMMON.getOrigin(), ChestRarity.COMMON.getBound());
            case RARE -> random.nextInt(ChestRarity.RARE.getOrigin(), ChestRarity.RARE.getBound());
            case LEGENDARY -> random.nextInt(ChestRarity.LEGENDARY.getOrigin(), ChestRarity.LEGENDARY.getBound());
        };
    }
}
