package model.animated;

import static model.animated.EntityType.BOSS;
import static model.animated.EntityType.MOVEABLE_ENEMY;
import static model.animated.EntityType.STATIC_ENEMY;
import static model.animated.BulletType.BOSS_BULLET;
import static model.animated.BulletType.ENEMY_BULLET;
import input.Command;
import model.ai.BasicAI;
import model.ai.BossAI;
import model.hitbox.HitBox;
import model.strategy.AimedProjectile;
import model.strategy.ChasePlayerProjectile;
import model.strategy.Motionless;
import model.strategy.SimplyDirectionMovement;
import model.strategy.SingleDirectionProjectile;
/**
 * 
 *
 */
public class EnemyFactoryImpl implements EnemyFactory {
    /**
     * 
     */
    @Override
    public Animated createStaticSimpleDirectionShotEnemy(final HitBox h, final Command c) {
        return new EnemyImpl(STATIC_ENEMY.getVel(), STATIC_ENEMY.getLife(), h, 
                new BasicAI(new Motionless(), new SingleDirectionProjectile(c)), 
                STATIC_ENEMY.getPoints(), ENEMY_BULLET.getRange());
    }
    /**
     * 
     */
    @Override
    public Animated createStaticAimedBulletEnemy(final HitBox h) {
        return new EnemyImpl(STATIC_ENEMY.getVel(), STATIC_ENEMY.getLife(), h, 
                new BasicAI(new Motionless(), new AimedProjectile()), 
                STATIC_ENEMY.getPoints(), ENEMY_BULLET.getRange());
    }
    /**
     * 
     */
    @Override
    public Animated createSimpleDirectionMovedEnemy(final HitBox h, final Command dMove, final Command dShot) {
        return new EnemyImpl(MOVEABLE_ENEMY.getVel(), MOVEABLE_ENEMY.getLife(), h, 
                new BasicAI(new SimplyDirectionMovement(dMove), new SingleDirectionProjectile(dShot)), 
                MOVEABLE_ENEMY.getPoints(), ENEMY_BULLET.getRange());
    }
    /**
     * Note: Boss start with bullet that chase player.
     */
    @Override
    public Animated createBoss(final HitBox h) {
        return new EnemyImpl(BOSS.getVel(), BOSS.getLife(), h, 
                new BossAI(new Motionless(), new ChasePlayerProjectile()), 
                BOSS.getPoints(), BOSS_BULLET.getRange());
    }
}
