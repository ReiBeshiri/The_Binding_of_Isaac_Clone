package model.room;

import java.util.List;

import model.hitbox.HitBox;
import model.inanimated.Door;
import model.inanimated.Wall;
/**
 * 
 * Abstract class for rooms.
 *
 */
public abstract class AbstractRoom implements Room {
    private final HitBox h;
    private final List<Door> doors;
    private final List<Wall> walls;

    /**
     * Constructor for a generic room.
     * @param h HitBox of room.
     * @param doors list of actual room's doors.
     * @param walls list of the walls in this room. 
     */
    public AbstractRoom(final HitBox h, final List<Door> doors, final List<Wall> walls) {
        this.h = h;
        this.doors = doors;
        this.walls = walls;
    }

    /**
     * return the list of actual room's doors. 
     */
    @Override
    public List<Door> getDoors() {
        return doors;
    }

    /**
     * return the room's HitBox.
     */
    @Override
    public HitBox getHitBox() {
        return h;
    }

    /**
     * Get walls of the room.
     */
    @Override
    public List<Wall> getWalls() {
        return walls;
    }
}
