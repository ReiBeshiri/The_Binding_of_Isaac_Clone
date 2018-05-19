package view;

import java.util.List;

import model.animated.Animated;
import model.inanimated.Door;
import model.room.Room;
import timer.TimeEventListener;

/**
 * Class that manage drawer.
 *
 */
public interface DrawerManager extends TimeEventListener {
    /**
     * Draw animated entities.
     * @param list List of dynamic enemy.
     */
    void drawAnimatedEntity(List<Animated> list);
    /**
     * Draw room.
     * @param room Room to draw.
     */
    void drawRoom(Room room);
    /**
     * Draw player life.
     * @param life Life to draw.
     */
    void drawPlayerLife(int life);
    /**
     * Change door status.
     * @param door door to change.
     */
    void changeDoorStatus(Door door);
}
