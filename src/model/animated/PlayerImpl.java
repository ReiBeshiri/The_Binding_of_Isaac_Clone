package model.animated;

import java.util.Collection;
import model.ai.AI;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import proxyutility.ImageType;
import static proxyutility.ImageType.PLAYER_BULLET;

/**
 * Implementation of the Player.
 */
public class PlayerImpl extends AbstractCharacter implements Player {
    // Represent the number of the bullet shooted by player.
    // In this case is always the same, for expansion, we only need to change this
    // constant
    // or implement a get, set and transform this to a private field.
    // private static final int N_BULLET_TO_SHOOT = 1;

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
     * @param range
     *            Range of his bullet.
     * @param img
     *            Image for player.
     * @param ratio
     *            shoot ratio for payer.
     */
    public PlayerImpl(final double v, final int life, final HitBox h, final AI ai, final double range,
            final ImageType img, final double ratio) {
        super(v, life, h, ai, range, img, ratio);
    }

    /**
     * Player Movement.
     */
    @Override
    public void move(final double dt) {
        // Safe-casting.
        super.setHitBox(super.getAI().move(dt, super.getVel(), (CircleHitBox) super.getHitBox()));
    }

    /**
     * Player shoot.
     */
    @Override
    public Collection<Bullet> shoot() {
        return super.getAI().shoot(super.getHitBox(), super.getVel(), super.getRange(), PLAYER_BULLET);
    }
}
