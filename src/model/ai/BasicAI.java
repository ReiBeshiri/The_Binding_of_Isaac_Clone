package model.ai;

import java.util.Collection;

import model.animated.Bullet;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import model.strategy.MovementStrategy;

/**
 * This class represent the generic logic to shoot and move.
 *
 */
public class BasicAI implements AI {
    private final MovementStrategy movementStrategy;
    private final BulletStrategy bulletStrategy; // Strategy for bullet...

    /**
     * Constructor of basic AI.
     * 
     * @param m
     *            Strategy of movement.
     * @param b
     *            Strategy for bullet.
     */
    public BasicAI(final MovementStrategy m, final BulletStrategy b) {
        movementStrategy = m;
        bulletStrategy = b;
    }

    /**
     * Generic movement.
     * 
     */
    @Override
    public HitBox move(final int dt, final double vel, final CircleHitBox hBox) {
        return movementStrategy.move(dt, vel, hBox);
    }

    /**
     * Generic shoot.
     * 
     * Note: We can add params to add personalization of shoot type (range, dmg)
     * ecc...
     */
    @Override
    public Collection<Bullet> shoot(final HitBox hBox, final double vel) {
        // TODO Need to know how bullets are implemented.
        // return bulletStrategy.shoot(hBox, vel);
    }
}
