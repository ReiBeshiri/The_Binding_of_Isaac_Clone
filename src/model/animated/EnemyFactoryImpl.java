package model.animated;
import static model.animated.EntityType.*;
import static model.animated.BulletType.*;
import input.Command;
import model.ai.BasicAI;
import model.hitbox.HitBox;
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
                new BasicAI(null, new SingleDirectionProjectile(c)), 
                STATIC_ENEMY.getPoints(), ENEMY_BULLET.getRange());
    }

    @Override
    public Animated createStaticAimedBulletEnemy(HitBox h) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Animated createSimpleDirectionMovedEnemy(HitBox h, Command c) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Animated createBoss(HitBox h) {
        // TODO Auto-generated method stub
        return null;
    }
   

}
