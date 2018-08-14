package model.animated;

import model.ai.AI;
import model.hitbox.HitBox;
import utility.ImageType;

/**
 * Implementation of the Player.
 */
public class PlayerImpl extends AbstractCharacter implements Player {

    /**
     * 
     * @param v
     *            Player's velocity.
     * @param life
     *            Player's life.
     * @param h
     *            HitBox.
     * @param ai
     *            Artificial Intelligence.
     * @param img
     *            Image for player.
     * @param ratio
     *            shoot ratio for payer.
     * @param bulletRadius
     *            Radius of bullet for this entity.
     * @param bulletVel
     *            Bullet velocity for this entity.
     * @param bulletRange
     *            Bullet range for this entity.
     * @param bulletDamage
     *            Bullet damage for this entity.
     * @param bulletImage
     *            Bullet Image for this enemy.
     */
    public PlayerImpl(final double v, final int life, final HitBox h, final AI ai, final ImageType img,
            final double ratio, final double bulletRadius, final double bulletVel, final double bulletRange,
            final int bulletDamage, final ImageType bulletImage) {
        super(v, life, h, ai, img, ratio, bulletRadius, bulletVel, bulletRange, bulletDamage, bulletImage);
    }
}
