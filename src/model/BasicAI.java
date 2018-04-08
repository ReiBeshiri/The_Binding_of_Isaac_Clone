package model;

import java.util.Collection;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;

/**
 * This class represent the player logic to shoot and move.
 *
 */
public class BasicAI implements AI {
    private final MovementStrategy movementStrategy;
    private final BulletStrategy  bulletStrategy; //Strategy for bullet...
    /**
     * Constructor of PlayerAI.
     * @param m Strategy of movement.
     * @param b Strategy for bullet.
     */
    public BasicAI(final MovementStrategy m, final BulletStrategy b) {
        movementStrategy = m;
        bulletStrategy = b;
    }
    /**
     * Player movement.
     * 
     */
    @Override
    public HitBox move(final int dt, final int vel, final CircleHitBox hBox) {
        return movementStrategy.move(dt, vel, hBox);
    }
    /**
     * Player shoot.
     * 
     * Note: We can add params to add personalization of shoot type (range, dmg) ecc...
     */
    @Override
    public Collection<Bullet> shoot(final HitBox hBox, final int vel, final int nBulletToShoot) {
        // TODO Need to know how bullets are implemented.
        // bulletStrategy.shoot(hBox, vel);
    }
}
