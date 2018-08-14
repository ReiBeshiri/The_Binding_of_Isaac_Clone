package model.animated;

import java.util.Collection;

import model.ai.AI;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import utility.ImageType;

/**
 * Abstract class for character that can move or shot.
 * 
 */
public abstract class AbstractCharacter extends AbstractAnimated implements Character {

    private int life;
    private final AI ai;
    private final int maxLife;
    private final double ratio;
    private double attendTime;
    private double bulletRange;
    private final double bulletRadius;
    private final double bulletVel;
    private int bulletDamage;
    private final ImageType bulletImg;

    /**
     * Constructor for this class.
     * 
     * @param v
     *            Velocity of this object.
     * @param life
     *            Life of this player.
     * @param h
     *            HitBox of object.
     * @param ai
     *            Artificial Intelligence.
     * @param img
     *            Image for this entity.
     * @param ratio
     *            Ratio for this entity.
     * @param bulletRadius
     *            Radius of bullet for this entity.
     * @param bulletVel
     *            Bullet vel for this entity.
     * @param bulletRange
     *            Bullet range for this entity.
     * @param bulletDamage
     *            Bullet damage for this entity.
     * @param bulletImage
     *            Image of bullets shot this entity.
     */
    public AbstractCharacter(final double v, final int life, final HitBox h, final AI ai, final ImageType img,
            final double ratio, final double bulletRadius, final double bulletVel, final double bulletRange,
            final int bulletDamage, final ImageType bulletImage) {
        super(v, h, img);
        this.life = life;
        this.maxLife = life;
        this.ai = ai;
        this.ratio = ratio;
        attendTime = 0;
        this.bulletDamage = bulletDamage;
        this.bulletRadius = bulletRadius;
        this.bulletRange = bulletRange;
        this.bulletVel = bulletVel;
        this.bulletImg = bulletImage;
    }

    /**
     * Setter for damage up.
     * 
     * @param damage
     *            the damage to increase.
     */
    public void setDamage(final int damage) {
        this.bulletDamage += damage;
    }

    /**
     * Shot bullets of entity. (Template Method).
     */
    @Override
    public Collection<Bullet> shoot() {
        return getAI().shoot(getHitBox(), getBulletVel(), getBulletRange(), bulletImg,
                getBulletDamage(), getBulletRadius());
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
     *            life to decrease.
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
     * Set new range.
     * 
     * Note: Uses for power-up.
     * 
     * @param incRange
     *            New range for entity bullets.
     */
    public void setRange(final double incRange) {
        bulletRange += incRange;
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
     * Return if entity can shot.
     * 
     * @return ratio if entity can shot.
     */
    public boolean canShot() {
        if (attendTime > ratio) {
            attendTime = 0;
            return true;
        }
        return false;
    }

    /**
     * Method used to increment attend time.
     * 
     * @param val
     *            value to increase.
     */
    public void incAttendTime(final double val) {
        attendTime += val;
    }

    /**
     * Getter for bullet vel.
     * 
     * @return bullet vel.
     */
    public double getBulletVel() {
        return bulletVel;
    }

    /**
     * Getter for bullet range.
     * 
     * @return bullet range.
     */
    public double getBulletRange() {
        return bulletRange;
    }

    /**
     * Getter for bullet radius.
     * 
     * @return bullet radius.
     */
    public double getBulletRadius() {
        return bulletRadius;
    }

    /**
     * Getter for bullet damage.
     * 
     * @return bullet damage.
     */
    public int getBulletDamage() {
        return bulletDamage;
    }

    /**
     * Perform entity movement.
     */
    @Override
    protected void move(final double dt) {
        setHitBox(getAI().move(dt, super.getVel(), (CircleHitBox) super.getHitBox()));
    }
}
