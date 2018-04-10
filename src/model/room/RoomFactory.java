package model.room;

import java.util.List;

import model.animated.Enemy;
import model.hitbox.HitBox;
import model.inanimated.Button;
import model.inanimated.Door;
import model.inanimated.Heart;

/**
 * 
 * Interface for room factory.
*/
public interface RoomFactory {
    /**
     * 
     * @param hitbox MainRoom's HitBox.
     * @param doors MainRoom's doors.
     * @param button MainRoom's button for start the round.
     * @return a MainRoom.
     */
    Room createMainRoom(HitBox hitbox, List<Door> doors, Button button);
    /**
     * 
     * @param hitbox BossRoom's HitBox.
     * @param doors BossRoom's doors.
     * @param boss The boss of the game.
     * @return a BossRoom.
     */
    Room createBossRoom(HitBox hitbox, List<Door> doors, Enemy boss);
    /**
     * 
     * @param hitbox ShopRoom's HitBox.
     * @param doors ShopRoom's doors.
     * @param heart The heart that you can buy.
     * @return a ShopRoom.
     */
    Room createShopRoom(HitBox hitbox, List<Door> doors, Heart heart);
}
