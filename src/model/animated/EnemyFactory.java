package model.animated;

import input.Command;
import model.hitbox.HitBox;
import proxyutility.ImageType;

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
     * @param bulletRadius
     *            Radius of shot bullet.
     * @param img
     *            Image that represent this enemy.
     * @param ratio
     *            shoot ratio for this enemy.
     * @return Animated type enemy.
     */
    Animated createStaticSimpleDirectionShotEnemy(HitBox h, Command c, double bulletRadius, ImageType img,
            double ratio);

    /**
     * 
     * @param h
     *            HitBox.
     * @param bulletRadius
     *            Radius of shot bullet.
     * @param img
     *            Image that represent this enemy.
     * @param ratio
     *            shoot ratio for this enemy.
     * @return Static enemy with aimed shot.
     */
    Animated createStaticAimedBulletEnemy(HitBox h, double bulletRadius, ImageType img, double ratio);

    /**
     * 
     * @param h
     *            HitBox.
     * @param dMove
     *            Direction to move.
     * @param dShot
     *            Direction to shot.
     * @param bulletRadius
     *            Radius of shot bullet.
     * @param img
     *            Image that represent this enemy.
     * @param ratio
     *            shoot ratio for this enemy.
     * @return Animated enemy thats move in a simple direction.
     */
    Animated createSimpleDirectionMovedEnemy(HitBox h, Command dMove, Command dShot, double bulletRadius, ImageType img,
            double ratio);

    /**
     * 
     * @param h
     *            HitBox.
     * @param bulletRadius
     *            Radius of shot bullet.
     * @param img
     *            Image that represent this enemy.
     * @param ratio
     *            shoot ratio for this enemy.
     * @return Boss.
     */
    Animated createBoss(HitBox h, double bulletRadius, ImageType img, double ratio);
}
