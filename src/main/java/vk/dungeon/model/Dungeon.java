package vk.dungeon.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import vk.dungeon.room.Room;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@Getter
public class Dungeon {
    private Map<String, Room> rooms;

    public Dungeon(String path) {
        initDungeon(path);
    }

    private void initDungeon(String path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            rooms = mapper.readValue(Files.readString(Path.of(path)), new TypeReference<>() {
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
