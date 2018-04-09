package model;

import java.util.List;

import model.hitbox.HitBox;
/**
 * 
 * Implement Room Factory.
 *
 */
public class RoomFactoryImpl implements RoomFactory {

    /**
     * ss.
     */
    @Override
    public Room createMainRoom(final HitBox hitbox, final List<Door> doors, final Button button) {
        return new MainRoom(hitbox, doors, button);
    }
    /**
     * ss.
     */
    @Override
    public Room createBossRoom(final HitBox hitbox, final List<Door> doors, final Enemy boss) {
        return new BossRoom(hitbox, doors, boss);
    }
    /**
     * ss.
     */
    @Override
    public Room createShopRoom(final HitBox hitbox, final List<Door> doors, final Heart heart) {
        return new ShopRoom(hitbox, doors, heart);
    }

}
