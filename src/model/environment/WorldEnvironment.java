package model.environment;

import java.util.List;

import model.room.Room;

/**
 * Create the world map with rooms and destination doors.
 */
public interface WorldEnvironment {
    /**
     * @return list of rooms in the world.
     */
List<Room> createWorld();
}
