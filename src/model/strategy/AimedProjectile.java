package model.strategy;

import java.util.ArrayList;
import java.util.Collection;
import model.animated.Bullet;
import model.animated.BulletImpl;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import proxyutility.ImageType;
import utility.ModelUtility;
/**
 * 
 * Shoots an aimed bullet to a specific point.
 *
 */
public class AimedProjectile implements ProjectileType {

    /**
     * Shoot a bullet/s.
     */
    @Override
    public Collection<Bullet> shoot(final HitBox sender, final double range, final double vel, final ImageType bulletImg, final int damage, final double radius) {
        final Collection<Bullet> bulletColl = new ArrayList<>();
        bulletColl.add(new BulletImpl(new CircleHitBox(sender.getX(), sender.getY(), radius), vel, 
                new BulletMovement(Math.atan2(-(ModelUtility.getPlayerHitBox().getY() - sender.getY()), ModelUtility.getPlayerHitBox().getX() - sender.getX())),
                range, bulletImg, damage));
        return bulletColl;
    }

}
