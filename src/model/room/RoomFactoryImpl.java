package model.room;

import java.util.List;

import model.gameobject.animated.Enemy;
import model.gameobject.inanimated.Button;
import model.gameobject.inanimated.Door;
import model.gameobject.inanimated.Heart;
import model.hitbox.HitBox;
/**
 * 
 * Implement Room Factory.
 *
 */
public class RoomFactoryImpl implements RoomFactory {

    /**
     * Create the MainRoom.
     */
    @Override
    public Room createMainRoom(final HitBox hitbox, final List<Door> doors, final Button button) {
        return new MainRoom(hitbox, doors, button);
    }
    /**
     * Create the BossRoom.
     */
    @Override
    public Room createBossRoom(final HitBox hitbox, final List<Door> doors, final Enemy boss) {
        return new BossRoom(hitbox, doors, boss);
    }
    /**
     * Create the ShopRoom.
     */
    @Override
    public Room createShopRoom(final HitBox hitbox, final List<Door> doors, final Heart heart) {
        return new ShopRoom(hitbox, doors, heart);
    }

}
