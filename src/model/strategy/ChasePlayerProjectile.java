package model.strategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import model.animated.Bullet;
import model.animated.BulletImpl;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
/**
 * 
 *
 */
public class ChasePlayerProjectile implements ProjectileType {
    private final double radius;
    /**
     * 
     * @param r Radius of bullet.
     */
    public ChasePlayerProjectile(final double r) {
        radius = r;
    }
    /**
     * 
     */
    @Override
    public Collection<Bullet> shoot(final HitBox sender, final double range, final double vel) {
        final List<Bullet> list = new ArrayList<>();
        list.add(new BulletImpl(new CircleHitBox(sender.getX(), sender.getY(), radius), 
                vel, new FollowPlayerMovement(), range));
        return list;
    }

}
