package model;

import java.util.List;

import model.hitbox.HitBox;
/**
 * 
 * BossRoom implements.
 *
 */
public class BossRoom extends AbstractRoom implements Room {
    private final Enemy boss;
    /**
     * 
     * @param h BossRoom's HitBox.
     * @param doors BossRoom's doors.
     * @param boss The game's boss.
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
