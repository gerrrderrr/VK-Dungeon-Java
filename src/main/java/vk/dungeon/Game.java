package vk.dungeon;

import vk.dungeon.model.Dungeon;
import vk.dungeon.model.Player;
import vk.dungeon.room.EmptyRoom;
import vk.dungeon.room.MonsterRoom;
import vk.dungeon.room.Room;
import vk.dungeon.room.TreasureRoom;

import java.util.*;

public class Game {
    private final Player player;
    private final Dungeon dungeon;

    public Game(Player player, Dungeon dungeon) {
        this.player = player;
        this.dungeon = dungeon;
    }

    public void start() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the game!\nFind a way from this dark and scary dungeon full of monsters.");
        Room room = dungeon.getRooms().get("1");
        Thread.sleep(1000);

        while (true) {
            if (room instanceof MonsterRoom monsterRoom) {
                System.out.printf("You have entered a room with a %s Monster.%n", monsterRoom.isVisited() ? "defeated" : "");
                player.addPoints(monsterRoom.startAFight());
            } else if (room instanceof TreasureRoom treasureRoom) {
                System.out.printf("You have entered a room with %s Treasure Chest.%n", treasureRoom.isVisited() ? "an empty" : "a");
                player.addPoints(treasureRoom.getReward());
            } else if (room instanceof EmptyRoom) System.out.println("You have entered an empty room.");


            if (room.isExit()) {
                System.out.println("There is a huge open door inside this room! It is so bright out there!");
                break;
            }

            System.out.printf("%nIn this room there %s %d door%s.%n%s%n",
                    room.getRoomIds().size() > 1 ? "are" : "is", room.getRoomIds().size(), room.getRoomIds().size() > 1 ? "s" : "", room.getRooms());

            int input = room.getId();

            while (!room.getRoomIds().contains(input)) {
                System.out.println("\nEnter the number of a door:");
                if (scanner.hasNextInt()) input = scanner.nextInt();
                scanner.nextLine();
            }
            room = dungeon.getRooms().get(String.valueOf(input));
        }
        System.out.printf("%nYou exited this dark dungeon and have received in total %d points!%nCONGRATULATION!!!", player.getScore());
        System.out.printf("%nThe shortest path was: %s", calculateShortestPath());
    }

    private String calculateShortestPath() {
        Queue<Room> queue = new LinkedList<>();
        Map<Room, Room> pathMap = new HashMap<>();
        Set<Room> visited = new HashSet<>();
        queue.add(dungeon.getRooms().get("1"));
        visited.add(dungeon.getRooms().get("1"));

        while (!queue.isEmpty()) {
            Room current = queue.poll();
            if (current.isExit()) {
                Deque<Integer> path = new LinkedList<>();
                for (Room at = current; at != null; at = pathMap.get(at)) {
                    path.addFirst(at.getId());
                }
                return path.toString();
            }

            for (int neighborId : current.getRoomIds()) {
                Room neighbor = dungeon.getRooms().get(String.valueOf(neighborId));
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    pathMap.put(neighbor, current);
                }
            }
        }
        return Collections.emptyList().toString();
    }
}
