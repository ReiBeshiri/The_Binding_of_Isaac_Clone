package model.strategy;

import java.util.Collection;

import input.Command;
import model.animated.Bullet;
import model.hitbox.HitBox;
/**
 * 
 * Represents all the type of projectiles in the game.
 *
 */
public interface ProjectileType {
    /**
     * Determines the bullets shot and the way they are shot.
     * @param sender
     *          The hitbox where the bullet starts.
     * @param dir
     *          The directions in which the projectile was shot.
     * @param dt
     *          Delta time.
     * @param range
     *          The range of the bullet.
     * @param vel
     *          The speed of the bullet.
     * @return
     *          The bullet that has been shot.
     */
    Collection<Bullet> shoot(HitBox sender, Collection<Command> dir, double dt, double range, double vel);
}
