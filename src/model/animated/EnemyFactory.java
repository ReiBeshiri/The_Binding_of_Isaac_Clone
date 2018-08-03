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
     * @param h
     *            HitBox.
     * @param c
     *            Direction.
     * @return Animated type enemy.
     */
    Animated createStaticSimpleDirectionShotEnemy(HitBox h, Command c);

    /**
     * 
     * @param h
     *            HitBox.
     * @return Static enemy with aimed shot.
     */
    Animated createStaticAimedBulletEnemy(HitBox h);

    /**
     * 
     * @param h
     *            HitBox.
     * @param dMove
     *            Direction to move.
     * @param dShot
     *            Direction to shot.
     * @return Animated enemy thats move in a simple direction.
     */
    Animated createSimpleDirectionMovedEnemy(HitBox h, Command dMove, Command dShot);

    /**
     * 
     * @param h
     *            HitBox.
     * @return Boss.
     */
    Animated createBoss(HitBox h);
}
