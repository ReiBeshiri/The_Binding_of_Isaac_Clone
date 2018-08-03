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
    public Animated createStaticSimpleDirectionShotEnemy(final HitBox h, final Command c) {
        return new EnemyImpl(STATIC_ENEMY.getVel(), STATIC_ENEMY.getLife(), h,
                new BasicAI(new Motionless(), new SingleDirectionProjectile(c)), STATIC_ENEMY.getPoints(),
                ImageType.BASIC_ENEMY, STATIC_ENEMY.getShotRatio(), ImageType.ENEMY_BULLET,
                STATIC_ENEMY.getBulletRadius(), STATIC_ENEMY.getBulletVel(), STATIC_ENEMY.getBulletRange(),
                STATIC_ENEMY.getBulletDamage());
    }

    /**
     * Create a static enemy that shot aimed bullets.
     */
    @Override
    public Animated createStaticAimedBulletEnemy(final HitBox h) {
        return new EnemyImpl(STATIC_ENEMY.getVel(), STATIC_ENEMY.getLife(), h,
                new BasicAI(new Motionless(), new AimedProjectile()), STATIC_ENEMY.getPoints(), ImageType.AIMED_ENEMY,
                STATIC_ENEMY.getShotRatio(), ImageType.ENEMY_BULLET, STATIC_ENEMY.getBulletRadius(),
                STATIC_ENEMY.getBulletVel(), STATIC_ENEMY.getBulletRange(), STATIC_ENEMY.getBulletDamage());
    }

    /**
     * Create a enemy that moves in only one direction and shot bullets in a single
     * direction.
     */
    @Override
    public Animated createSimpleDirectionMovedEnemy(final HitBox h, final Command dMove, final Command dShot) {
        return new EnemyImpl(MOVEABLE_ENEMY.getVel(), MOVEABLE_ENEMY.getLife(), h,
                new BasicAI(new SimplyDirectionMovement(dMove), new SingleDirectionProjectile(dShot)),
                MOVEABLE_ENEMY.getPoints(), ImageType.BASIC_ENEMY, MOVEABLE_ENEMY.getShotRatio(),
                ImageType.ENEMY_BULLET, MOVEABLE_ENEMY.getBulletRadius(), MOVEABLE_ENEMY.getBulletVel(),
                MOVEABLE_ENEMY.getBulletRange(), MOVEABLE_ENEMY.getBulletDamage());
    }

    /**
     * Create boss with initial behavior. Note: Boss start with bullet that chase
     * player.
     */
    @Override
    public Animated createBoss(final HitBox h) {
        return new EnemyImpl(BOSS.getVel(), BOSS.getLife(), h,
                new BossAI(new Motionless(), new ChasePlayerProjectile()), BOSS.getPoints(), ImageType.BOSS_ENEMY,
                BOSS.getShotRatio(), ImageType.BOSS_BULLET, BOSS.getBulletRadius(), BOSS.getBulletVel(),
                BOSS.getBulletRange(), BOSS.getBulletDamage());
    }
}
