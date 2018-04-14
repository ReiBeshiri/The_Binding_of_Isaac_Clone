package model.animated;

import java.util.Collection;

import model.ai.AI;
import model.hitbox.HitBox;

/**
 * Abstract class for character that can move or shot.
 * 
 */
public abstract class AbstractCharacter implements Animated {
    private double velocity;
    private int life;
    private final AI ai;
    private HitBox hitBox;
    private double range;

    /**
     * 
     * @param v
     *            Velocity of this object.
     * @param life
     *            Life of this player.
     * @param h
     *            HitBox of object.
     * @param ai
     *            Artificial Intelligence.
     * @param range
     *            Range of his bullet.
     */
    public AbstractCharacter(final double v, final int life, final HitBox h, final AI ai, final double range) {
        velocity = v;
        this.life = life;
        this.ai = ai;
        hitBox = h;
        this.range = range;
    }

    /**
     * 
     * @param dt
     *            DeltaTime to perform move.
     */
    protected abstract void move(int dt);

    /**
     * 
     * @return Collection of new Bullets, that depend on the type of enemy.
     */
    protected abstract Collection<Bullet> shoot();

    /**
     * Get vel.
     */
    @Override
    public double getVel() {
        return velocity;
    }

    /**
     * Setter for vel.
     */
    @Override
    public void setVel(final double vel) {
        velocity = vel;
    }

    /**
     * Update the state of entity. (Template Method).
     */
    @Override
    public void update(final int dt) {
        move(dt);
    }

    /**
     * Return life of the entity.
     * 
     * @return Life of the entity.
     */
    public int getLife() {
        return life;
    }

    /**
     * 
     * @param dec
     *            life to dec.
     */
    public void decLife(final int dec) {
        life -= dec;
    }
    /**
     * Method to expose the AI only to subclass.
     * 
     * @return AI.
     */
    public AI getAI() {
        return ai;
    }
    /**
     * Method to expose the range only to subclass.
     * 
     * @return range.
     */
    public double getRange() {
        return range;
    }
    /**
     * Set new range.
     * 
     * Note: Uses for power-up.
     * @param incRange New range for entity bullets.
     */
    public void setRange(final double incRange) {
        range += incRange;
    }
    /**
     * Return HitBox.
     */
    @Override
    public HitBox getHitBox() {
        return hitBox;
    }
    /**
     * Set HitBox.
     */
    @Override
    public void setHitBox(final HitBox h) {
        hitBox = h;
    }
}
