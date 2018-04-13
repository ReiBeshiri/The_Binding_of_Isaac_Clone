package model.room;

import java.util.List;

import model.hitbox.HitBox;
import model.inanimated.Door;
/**
 * 
 * Interface that represents rooms in the world.
 *      BISOGNA FARE LA SINGLETON.
 */
public interface Room {
    /**
     * 
     * @return a list of actual room's doors. 
     */
    List<Door> getDoors();
    /**
     * 
     * @return HitBox of the room.
     */
    HitBox getHitBox();
}
