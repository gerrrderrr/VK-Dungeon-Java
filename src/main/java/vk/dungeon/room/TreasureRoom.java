package vk.dungeon.room;

import lombok.Getter;
import lombok.Setter;
import vk.dungeon.model.Chest;
import vk.dungeon.room.Room;

@Getter
@Setter
public class TreasureRoom extends Room {

    private Chest chest;

    public int getReward() {
        if (isVisited()) {
            return 0;
        }
        System.out.printf("Look there is a beautiful %s chest with %d coins inside!%n", chest.getRarity(), chest.getValue());
        setVisited(true);
        return chest.getValue();
    }
}
