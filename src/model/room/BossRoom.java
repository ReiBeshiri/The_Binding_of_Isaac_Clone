package model.room;

import java.util.List;

import model.animated.Enemy;
import model.hitbox.HitBox;
import model.inanimated.Door;
/**
 * 
 * BossRoom implement.
 *
 */
public class BossRoom extends AbstractRoom {
    private final Enemy boss;
    /**
     * 
     * @param h BossRoom's HitBox.
     * @param doors BossRoom's doors.
     * @param boss The boss of the game.
     */
    public BossRoom(final HitBox h, final List<Door> doors, final Enemy boss) {
        super(h, doors);
        this.boss = boss;
    }
    /**
     * 
     * @return the game's boss.
     */
    public Enemy getBoss() {
        return this.boss;
    }

}
