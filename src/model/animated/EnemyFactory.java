package model.animated;

import input.Command;
import model.hitbox.HitBox;

/**
 * Factory for enemy.
 * 
 * Note: We can add different type of enemy, depending of ai created.
 */
public interface EnemyFactory {
    /**
     * 
     * @param h HitBox.
     * @param c Direction.
     * @param bulletRadius Radius of shottend bullet.
     * @return Animated type enemy.
     */
    Animated createStaticSimpleDirectionShotEnemy(HitBox h, Command c, double bulletRadius);
    /**
     * 
     * @param h HitBox.
     * @param bulletRadius Radius of shottend bullet.
     * @return Static enemy with aimed shot.
     */
    Animated createStaticAimedBulletEnemy(HitBox h, double bulletRadius);
    /**
     * 
     * @param h HitBox.
     * @param dMove Direction to move.
     * @param dShot Direction to shot.
     * @param bulletRadius Radius of shottend bullet.
     * @return Animated enemy thats move in a simple direction.
     */
    Animated createSimpleDirectionMovedEnemy(HitBox h, Command dMove, Command dShot, double bulletRadius);
    /**
     * 
     * @param h HitBox.
     * @param bulletRadius Radius of shottend bullet.
     * @return Boss.
     */
    Animated createBoss(HitBox h, double bulletRadius);
}
