package model.room;

import java.util.List;

import model.gameobject.inanimated.Door;
import model.gameobject.inanimated.Heart;
import model.hitbox.HitBox;
/**
 * 
 * ShopRoom implement.
 *
 */
public class ShopRoom extends AbstractRoom {
    private final Heart heart;
    /**
     * 
     * @param h ShopRoom's HitBox.
     * @param doors ShopRoom's doors.
     * @param heart The heart that you can buy.
     */
    public ShopRoom(final HitBox h, final List<Door> doors, final Heart heart) {
        super(h, doors);
        this.heart = heart;
    }
    /**
     * @return the heart that you can buy.
     */
    public Heart getHeart() {
        return this.heart;
    }

}
