package model.ai;

import java.util.Collection;

import model.animated.Bullet;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import model.strategy.MovementStrategy;
import model.strategy.ProjectileType;

/**
 * This class represent the generic logic to shoot and move.
 *
 */
public class BasicAI implements AI {
    private final MovementStrategy movementStrategy;
    private final ProjectileType pType;

    /**
     * Constructor of basic AI.
     * 
     * @param m
     *            Strategy of movement.
     * @param p
     *            Strategy for bullet.
     */
    public BasicAI(final MovementStrategy m, final ProjectileType p) {
        movementStrategy = m;
        pType = p;
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
        return pType.shoot(hBox, dir, dt, range, vel);
    }
}
