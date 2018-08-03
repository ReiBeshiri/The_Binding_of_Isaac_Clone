package model.ai;

import java.util.Collection;
import input.Command;
import model.animated.Bullet;
import model.animated.EntityStats;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import model.strategy.BossAimedComboProjectile;
import model.strategy.BossSimpleComboProjectile;
import model.strategy.MovementStrategy;
import model.strategy.ProjectileType;
import proxyutility.ImageType;
import utility.ProportionUtility;

/**
 * Boss AI.
 * 
 */
public class BossAI implements AI {
    private static final int PHASE2_INIT = 20;
    private static final int PHASE3_INIT = 5;
    private static final int SECOND_PHASE_START_BULLET_NUM = 10;
    private static final int THIRD_PHASE_START_BULLET_NUM = 10;
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
    public HitBox move(final double dt, final double vel, final CircleHitBox hBox) {
        return movementStrategy.move(dt, vel, hBox);
    }

    /**
     * Shoot.
     */
    @Override
    public Collection<Bullet> shoot(final HitBox hBox, final double vel, final double range,
            final ImageType bulletImg) {
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
     * Decide next step and set correct strategy.
     */
    @Override
    public void nextPhaseStrategy(final int life) {
        if (life <= PHASE3_INIT) {
            setProjectileType(
                    new BossAimedComboProjectile(EntityStats.BOSS.getBulletRadius(), THIRD_PHASE_START_BULLET_NUM));
        } else if (life <= PHASE2_INIT) {
            setProjectileType(new BossSimpleComboProjectile(Command.LEFT, EntityStats.BOSS.getBulletRadius(),
                    SECOND_PHASE_START_BULLET_NUM));
        }
    }

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
