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
     * Creates a static enemy that shot in a single direction.
     * 
     * @param h
     *            HitBox.
     * @param c
     *            Direction.
     * @return Animated type enemy.
     */
    Animated createStaticSimpleDirectionShotEnemy(HitBox h, Command c);

    /**
     * Create a enemy that shot in direction of player.
     * 
     * @param h
     *            HitBox.
     * @return Static enemy with aimed shot.
     */
    Animated createStaticAimedBulletEnemy(HitBox h);

    /**
     * Create a enemy that moves on a single direction and shot in a single
     * direction.
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
     * Create a enemy that shot in direction of player.
     * 
     * @param h
     *            HitBox of sender.
     * @return Animated enemy that shot bullets that follow player.
     */
    Animated createStaticEnemyFollowPlayerBullet(HitBox h);

    /**
     * Create a enemy that shot in all four directions.
     * 
     * @param h
     *            HitBox of sender.
     * @return Animated enemy that shot bullets in four main directions.
     */
    Animated createStaticEnemyFourWayProjectile(HitBox h);

    /**
     * Create boss.
     * @param h
     *            HitBox.
     * @return Boss.
     */
    Animated createBoss(HitBox h);
}
