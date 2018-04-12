package model.strategy;

import java.util.ArrayList;
import java.util.Collection;

import input.Command;
import model.animated.Bullet;
import model.animated.BulletImpl;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
/**
 * 
 * Shoots a aimed bullet to a specific point.
 *
 */
public class AimedProjectile implements ProjectileType {

    private double radius;
    /**
     * Constructs a new instance of an aimed projectile.
     */
    public AimedProjectile() {
        radius = 1;
    }

    @Override
    public Collection<Bullet> shoot(HitBox sender, Collection<Command> dir, double dt, double range, double vel) {
        final Collection<Bullet> bulletColl = new ArrayList<>();
        bulletColl.add(new BulletImpl(new CircleHitBox(sender.getX(), sender.getY(), radius), vel, new AimedMovement(), range));
        return bulletColl;
    }

}