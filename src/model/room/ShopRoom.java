package model.room;

import java.util.List;

import model.hitbox.HitBox;
import model.inanimated.Door;
import model.inanimated.Inanimated;
import model.inanimated.Wall;
/**
 * 
 * ShopRoom implement.
 *
 */
public class ShopRoom extends AbstractRoom {
    private final List<Inanimated> items;

    /**
     * Constructor of the room.
     * @param h ShopRoom's HitBox.
     * @param doors ShopRoom's doors.
     * @param items List of power up.
     * @param walls list of the wall of the room.
     */
    public ShopRoom(final HitBox h, final List<Door> doors, final List<Inanimated> items, final List<Wall> walls) {
        super(h, doors, walls);
        this.items = items;
    }

    /**
     * @return List of items that you can buy.
     */
    public List<Inanimated> getItems() {
        return this.items;
    }

}
