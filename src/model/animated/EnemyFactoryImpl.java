package model.animated;

import input.Command;
import model.ai.BasicAI;
import model.ai.BossAI;
import model.hitbox.HitBox;
import model.strategy.AimedProjectile;
import model.strategy.ChasePlayerProjectile;
import model.strategy.Motionless;
import model.strategy.SimplyDirectionMovement;
import model.strategy.SingleDirectionProjectile;
import proxyutility.ImageType;
import static model.animated.EntityStats.BOSS;
import static model.animated.EntityStats.MOVEABLE_ENEMY;
import static model.animated.EntityStats.STATIC_ENEMY;

/**
 * Factory implementation for enemy.
 *
 */
public class EnemyFactoryImpl implements EnemyFactory {
    /**
     * Create static enemy that shot in only direction.
     */
    @Override
    public Animated createStaticSimpleDirectionShotEnemy(final HitBox h, final Command c, final double bulletRadius,
            final ImageType img, final double ratio) {
        return new EnemyImpl(STATIC_ENEMY.getVel(), STATIC_ENEMY.getLife(), h,
                new BasicAI(new Motionless(), new SingleDirectionProjectile(c, bulletRadius)), STATIC_ENEMY.getPoints(),
                EntityStats.STATIC_ENEMY.getBulletRange(), ImageType.BASIC_ENEMY, STATIC_ENEMY.getShotRatio(),
                ImageType.ENEMY_BULLET);
    }

    /**
     * Create a static enemy that shot aimed bullets.
     */
    @Override
    public Animated createStaticAimedBulletEnemy(final HitBox h, final double bulletRadius, final ImageType img,
            final double ratio) {
        return new EnemyImpl(STATIC_ENEMY.getVel(), STATIC_ENEMY.getLife(), h,
                new BasicAI(new Motionless(), new AimedProjectile(bulletRadius)), STATIC_ENEMY.getPoints(),
                EntityStats.STATIC_ENEMY.getBulletRange(), ImageType.AIMED_ENEMY, STATIC_ENEMY.getShotRatio(),
                ImageType.ENEMY_BULLET);
    }

    /**
     * Create a enemy that moves in only one direction and shot bullets in a single
     * direction.
     */
    @Override
    public Animated createSimpleDirectionMovedEnemy(final HitBox h, final Command dMove, final Command dShot,
            final double bulletRadius, final ImageType img, final double ratio) {
        return new EnemyImpl(MOVEABLE_ENEMY.getVel(), MOVEABLE_ENEMY.getLife(), h,
                new BasicAI(new SimplyDirectionMovement(dMove), new SingleDirectionProjectile(dShot, bulletRadius)),
                MOVEABLE_ENEMY.getPoints(), EntityStats.MOVEABLE_ENEMY.getBulletRange(), ImageType.BASIC_ENEMY,
                MOVEABLE_ENEMY.getShotRatio(), ImageType.ENEMY_BULLET);
    }

    /**
     * Create boss with initial behavior. Note: Boss start with bullet that chase
     * player.
     */
    @Override
    public Animated createBoss(final HitBox h, final double bulletRadius, final ImageType img, final double ratio) {
        return new EnemyImpl(BOSS.getVel(), BOSS.getLife(), h,
                new BossAI(new Motionless(), new ChasePlayerProjectile(bulletRadius)), BOSS.getPoints(),
                EntityStats.BOSS.getBulletRange(), ImageType.BOSS_ENEMY, BOSS.getShotRatio(), ImageType.BOSS_BULLET);
    }
}
