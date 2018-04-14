package model.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import input.Command;
import model.animated.Bullet;
import model.animated.BulletImpl;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
/**
 * Projectile in a single basic direction.
 */
public class SingleDirectionProjectile implements ProjectileType {
    private final Command dir;
    /**
     * 
     * @param dir Direction where shoot the bullet. 
     */
    public SingleDirectionProjectile(final Command dir) {
        this.dir = dir;
    }
    /**
     * 
     */
    @Override
    public Collection<Bullet> shoot(final HitBox sender, final double range, final double vel) {
        final List<Bullet> list = new ArrayList<>();
        list.add(new BulletImpl(new CircleHitBox(sender.getX(), sender.getY(), ((CircleHitBox) sender).getRadius()), 
                vel, new SimplyDirectionMovement(dir), range));
        return list;
    }

}
