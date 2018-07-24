package model.animated;

import java.util.Collection;

import model.ai.AI;
import model.hitbox.HitBox;
import proxyutility.ImageType;

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
    private final int maxLife;
    private final double ratio;
    private final ImageType img;

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
     * @param img
     *            Image for this entity.
     * @param ratio
     *            Ratio for this entity.
     */
    public AbstractCharacter(final double v, final int life, final HitBox h, final AI ai, final double range,
            final ImageType img, final double ratio) {
        velocity = v;
        this.life = life;
        this.maxLife = life;
        this.ai = ai;
        hitBox = h;
        this.range = range;
        this.ratio = ratio;
        this.img = img;
    }

    /**
     * 
     * @param dt
     *            DeltaTime to perform move.
     */
    protected abstract void move(double dt);

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
    public void update(final double dt) {
        move(dt);
    }

    /**
     * Shot bullets of entity. (Template Method).
     */
    @Override
    public Collection<Bullet> shot() {
        return shoot();
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
     * 
     * @param incRange
     *            New range for entity bullets.
     */
    public void setRange(final double incRange) {
        range += incRange;
    }

    /**
     * Increase life if entity doesn't have max life already.
     * 
     * @param inc
     *            Delta to increase life.
     */
    public void incLife(final int inc) {
        if (this.life + inc <= this.maxLife) {
            this.life += inc;
        } else if (this.life + inc > this.maxLife) {
            this.life = this.maxLife;
        }
    }
    /**
     * 
     */
    @Override
    public ImageType getImageType() {
        return img;
    }
    /**
     * Return shot ratio.
     * @return ratio for this character.
     */
    public double getShootRatio() {
        return this.ratio;
    }
}
