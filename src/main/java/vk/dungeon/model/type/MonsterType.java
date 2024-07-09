package vk.dungeon.model.type;

import lombok.Getter;

@Getter
public enum MonsterType {
    COMMON(10, 15, 1),
    CHAMPION(16, 20, 2),
    BOSS(21, 25, 3),
    LEGENDARY(26, 30, 4);

    private final int origin;
    private final int bound;
    private final int damage;

    MonsterType(int origin, int bound, int damage) {
        this.origin = origin;
        this.bound = bound;
        this.damage = damage;
    }
}
