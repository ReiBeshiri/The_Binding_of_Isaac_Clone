package model.animated;

import java.util.Collection;

import model.ai.AI;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;

/**
 * Implementation of the Player.
 */
public class PlayerImpl extends AbstractCharacter implements Player {
    // Represent the number of the bullet shooted by player.
    // In this case is always the same, for expansion, we only need to change this
    // constant
    // or implement a get, set and transform this to a private field.
    //private static final int N_BULLET_TO_SHOOT = 1;

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
     */
    public PlayerImpl(final double v, final int life, final HitBox h, final AI ai) {
        super(v, life, h, ai);
    }

    /**
     * Player Movement.
     */
    @Override
    public void move(final int dt) {
        // Safe-casting.
        super.setHitBox(super.getAI().move(dt, super.getVel(), (CircleHitBox) super.getHitBox()));
    }

    /**
     * Player shoot.
     */
    @Override
    public Collection<Bullet> shot() {
        return super.getAI().shoot(super.getHitBox(), super.getVel());
    }
}
