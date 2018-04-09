package model;

import java.util.List;

import model.hitbox.HitBox;

/**
 * 
 * Interface for room factory.
 *
 */
public interface RoomFactory {
    /**
     * 
     * @param hitbox MainRoom's HitBox.
     * @param doors s
     * @param button s
     * @return a MainRoom.
     */
    Room createMainRoom(HitBox hitbox, List<Door> doors, Button button);
    /**
     * 
     * @param hitbox BossRoom's HitBox.
     * @param doors s 
     * @param boss s
     * @return a BossRoom.
     */
    Room createBossRoom(HitBox hitbox, List<Door> doors, Enemy boss);
    /**
     * 
     * @param hitbox ShopRoom's HitBox.
     * @param doors s
     * @param heart s
     * @return a ShopRoom.
     */
    Room createShopRoom(HitBox hitbox, List<Door> doors, Heart heart);
}
