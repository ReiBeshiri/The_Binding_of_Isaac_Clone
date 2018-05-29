package model.ai;

import java.util.Collection;

import model.animated.Bullet;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import model.strategy.MovementStrategy;
import model.strategy.ProjectileType;
import proxyutility.ImageType;
/**
 * Boss AI.
 * 
 */
public class BossAI implements AI {
    private static final int PHASE2_INIT = 20;
    private static final int PHASE3_INIT = 5;
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
    public BossAI(final MovementStrategy m, final ProjectileType p) {
        movementStrategy = m;
        pType = p;
    }
    /**
     * Move.
     */
    @Override
    public HitBox move(final int dt, final double vel, final CircleHitBox hBox) {
        return movementStrategy.move(dt, vel, hBox);
    }
    /**
     * Shoot.
     */
    @Override
    public Collection<Bullet> shoot(final HitBox hBox, final double vel, final double range, final ImageType bulletImg) {
        return pType.shoot(hBox, range, vel, bulletImg);
    }
    /**
     * Set movement startegy.
     */
    @Override
    public void setMovementStrategy(final MovementStrategy mS) {
        movementStrategy = mS;
    }
    /**
     * Set next projectile type.
     */
    @Override
    public void setProjectileType(final ProjectileType pT) {
        pType = pT;
    }
    /**
     * Decide next step.
     */
    @Override
    public void nextPhaseStrategy(final int life) {
        if (life <= PHASE3_INIT) {
            //Set third_strategy.
        } else if (life <= PHASE2_INIT) {
            //Set second_phase.
        }
    }

}
