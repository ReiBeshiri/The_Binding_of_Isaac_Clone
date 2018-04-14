package model.animated;
/**
 * Factory for enemy.
 * 
 * Note: We can add different type of enemy, depending of ai created.
 */
public interface EnemyFactory {
    /**
     * 
     * @return Animated Enemy.
     */
    Animated createStaticSimpleDirectionShotEnemy();
    /**
     * 
     * @return Animated Enemy.
     */
    Animated createStaticAimedBulletEnemy();
    /**
     * 
     * @return Animated Enemy.
     */
    Animated createSimpleDirectionMovedEnemy();
    /**
     * 
     * @return Animated Enemy.
     */
    Animated createBoss();
}
