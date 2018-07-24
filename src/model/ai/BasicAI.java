package model.ai;

import java.util.Collection;

import model.animated.Bullet;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import model.strategy.MovementStrategy;
import model.strategy.ProjectileType;
import proxyutility.ImageType;

/**
 * This class represent the generic logic to shoot and move.
 *
 */
public class BasicAI implements AI {
    private MovementStrategy movementStrategy;
    private ProjectileType pType;

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
    public HitBox move(final double dt, final double vel, final CircleHitBox hBox) {
        return movementStrategy.move(dt, vel, hBox);
    }

    /**
     * Generic shoot.
     * 
     * Note: We can add params to add personalization of shoot type (range, dmg)
     * ecc...
     */
    @Override
    public Collection<Bullet> shoot(final HitBox hBox, final double vel, final double range, final ImageType bulletImg) {
        return pType.shoot(hBox, range, vel, bulletImg);
    }

    /**
     * Set new Movement Strategy.
     * Note: We can use this method in a player for poweUp.
     */
    @Override
    public void setMovementStrategy(final MovementStrategy mS) {
        movementStrategy = mS;
    }

    /**
     * Set new Projectile Strategy.
     * Note: We can use this method in a player for poweUp.
     */
    @Override
    public void setProjectileType(final ProjectileType pT) {
        pType = pT;
    }

    /**
     * For boss Decision.
     */
    @Override
    public void nextPhaseStrategy(final int life) { }

    /**
     * Used in phase of test.
     */
    @Override
    public ProjectileType getProjType() {
        return pType;
    }

    /**
     * Used in phase of test.
     */
    @Override
    public MovementStrategy getMovementStrategy() {
        return movementStrategy;
    }
}
