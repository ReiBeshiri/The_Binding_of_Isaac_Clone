package model;

import java.util.Collection;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;

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
    public Collection<Bullet> shoot(final HitBox hBox, final double vel, final int nBulletToShoot) {
        // TODO Need to know how bullets are implemented.
        // bulletStrategy.shoot(hBox, vel);
    }
}
