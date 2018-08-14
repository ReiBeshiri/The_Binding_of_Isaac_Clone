package model.animated;

import model.hitbox.HitBox;
import utility.Command;

/**
 * Factory for enemy.
 * 
 */
public interface CharacterFactory {

    /**
     * Creates a static enemy that shot in a single direction.
     * 
     * @param h
     *            HitBox.
     * @param c
     *            Direction.
     * @return Static enemy that shots in a single direction.
     */
    Enemy createStaticSimpleDirectionShotEnemy(HitBox h, Command c);

    /**
     * Create a enemy that shot in direction of player.
     * 
     * @param h
     *            HitBox.
     * @return Static enemy with aimed shot.
     */
    Enemy createStaticAimedBulletEnemy(HitBox h);

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
     * @return enemy thats move in a simple direction.
     */
    Enemy createSimpleDirectionMovedEnemy(HitBox h, Command dMove, Command dShot);

    /**
     * Create a enemy that shot in direction of player.
     * 
     * @param h
     *            HitBox of sender.
     * @return enemy that shot bullets that follow player.
     */
    Enemy createStaticEnemyFollowPlayerBullet(HitBox h);

    /**
     * Create a enemy that shot in all four basic directions.
     * 
     * @param h
     *            HitBox of sender.
     * @return enemy that shot bullets in four main directions.
     */
    Enemy createStaticEnemyFourWayStraightProjectile(HitBox h);

    /**
     * Create a enemy that shot in the four diagonal directions.
     * 
     * @param h
     *            HitBox.
     * @return enemy that shot bullets in four diagonal directions.
     */
    Enemy createStaticEnemyFourWayDiagonalProjectile(HitBox h);

    /**
     * Create boss.
     * 
     * @param h
     *            HitBox.
     * @return Boss.
     */
    Enemy createBoss(HitBox h);

    /**
     * Create player.
     * 
     * @param h
     *            HitBox.
     * @return Player.
     */
    Player createPlayer(HitBox h);
}
