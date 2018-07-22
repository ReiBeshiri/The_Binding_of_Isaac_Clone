package model.room;

import java.util.List;

import model.animated.Enemy;
import model.hitbox.HitBox;
import model.inanimated.Door;
import model.inanimated.Wall;
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
     * @param walls list of walls in the room.
     */
    public BossRoom(final HitBox h, final List<Door> doors, final Enemy boss, final List<Wall> walls) {
        super(h, doors, walls);
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
