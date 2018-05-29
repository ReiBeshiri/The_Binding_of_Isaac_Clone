package model.strategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import input.Command;
import model.animated.Bullet;
import model.animated.BulletImpl;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import static proxyutility.ImageType.ENEMY_BULLET;
/**
 * 
 * Shots designed with unique behavior.
 * May be shot by the boss.
 *
 */
public class BossComboProjectile implements ProjectileType {

    private final Command dir;
    private final double radius;
    private final int[] xAxisSpownPoints = {-100, -80, -60, -40, -20, 0, 20, 40, 60, 80, 100};
    private static final int Y_AXIS = 50;
    /**
     * Constructor that initialize the common variables.
     * @param dir Direction where shoot the bullet. 
     * @param r radius of bullet.
     */
    public BossComboProjectile(final Command dir, final double r) {
        this.dir = dir;
        radius = r;
    }

    /**
     * Shoot bullet/s of boss.
     */
    @Override
    public final Collection<Bullet> shoot(final HitBox sender, final double range, final double vel) {
        final List<Bullet> list = new ArrayList<>();
        for (final int xPos : xAxisSpownPoints) {
            list.add(new BulletImpl(new CircleHitBox(sender.getX() + xPos, sender.getY() + Y_AXIS, radius), 
                    vel, new SimplyDirectionMovement(dir), range, ENEMY_BULLET));
        }
        list.add(new BulletImpl(new CircleHitBox(sender.getX(), sender.getY(), radius), 
                vel, new SimplyDirectionMovement(dir), range, ENEMY_BULLET));
        return list;
    }
}
