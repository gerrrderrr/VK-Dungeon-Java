package vk.dungeon.room;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = TreasureRoom.class, name = "treasure"),
        @JsonSubTypes.Type(value = MonsterRoom.class, name = "monster"),
        @JsonSubTypes.Type(value = EmptyRoom.class, name = "empty")
})
@Getter
@Setter
@NoArgsConstructor
public abstract class Room {

    private int id;
    private String name;
    private boolean isVisited = false;
    private boolean isExit;
    private Set<Integer> roomIds;

    public String getRooms() {
        return roomIds.toString();
    }
}
