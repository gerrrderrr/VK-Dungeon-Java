package vk.dungeon.model.type;

import lombok.Getter;

@Getter
public enum ChestRarity {
    COMMON(1, 10),
    RARE(11, 20),
    LEGENDARY(21, 30);

    private final int origin;
    private final int bound;

    ChestRarity(int origin, int bound) {
        this.origin = origin;
        this.bound = bound;
    }
}
