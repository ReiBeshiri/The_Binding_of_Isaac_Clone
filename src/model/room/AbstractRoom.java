package model.room;

import java.util.List;

import model.gameobject.inanimated.Door;
import model.hitbox.HitBox;
/**
 * 
 * Abstract class for rooms.
 *
 */
public abstract class AbstractRoom implements Room {
    private final HitBox h;
    private final List<Door> doors;
    /**
     * 
     * @param h HitBox of room.
     * @param doors list of actual room's doors. 
     */
    public AbstractRoom(final HitBox h, final List<Door> doors) {
        this.h = h;
        this.doors = doors;
    }
    /**
     * return the list of actual room's doors. 
     */
    @Override
    public List<Door> getList() {
        return doors;
    }
    /**
     * return the room's HitBox.
     */
    @Override
    public HitBox getHitBox() {
        return h;
    }

}
