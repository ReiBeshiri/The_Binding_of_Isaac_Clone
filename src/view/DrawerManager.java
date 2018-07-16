package view;

import java.util.List;

import model.animated.Animated;
import model.room.Room;
import timer.TimeEventListener;

/**
 * Class that manage the drawer on the two canvas of the game.
 *
 */
public interface DrawerManager extends TimeEventListener {

    /**
     * Set Player life.
     * @param life life.
     */
    void setPlayerLife(int life);

    /**
     * Set Animated entities.
     * @param entities list of entities.
     */
    void setAnimatedEntities(List<Animated> entities);

    /**
     * Set actual room.
     * @param room actual room.
     */
    void setRoom(Room room);

    /**
     * Draw scene.
     */
    void draw();
}
