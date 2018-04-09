package model;

import java.util.List;

import model.hitbox.HitBox;
/**
 * 
 * Interface that represents rooms in the world.
 *
 */
public interface Room {
    /**
     * 
     * @return a list of actual room's doors. 
     */
    List<Door> getList();
    /**
     * 
     * @return HitBox of the room.
     */
    HitBox getHitBox();
}
