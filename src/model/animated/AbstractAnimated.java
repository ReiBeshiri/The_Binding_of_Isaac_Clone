package model.animated;

import model.hitbox.HitBox;
import utility.ImageType;

/**
 * Abstract class for animated entities.
 *
 */
public abstract class AbstractAnimated implements Animated {

    private double vel;
    private HitBox hb;
    private final ImageType img;

    /**
     * Constructor for this class.
     * 
     * @param vel
     *            velocity of entity.
     * @param hitBox
     *            HitBox of entity.
     * @param img
     *            Image of entity.
     */
    public AbstractAnimated(final double vel, final HitBox hitBox, final ImageType img) {
        this.vel = vel;
        this.hb = hitBox;
        this.img = img;
    }

    /**
     * Abstract method for movement that hit implementations depends of specific
     * type.
     * 
     * @param dt
     *            delta time to update position.
     */
    protected abstract void move(double dt);

    /**
     * Update the state of entity. (Template Method).
     */
    @Override
    public void update(final double dt) {
        move(dt);
    }

    /**
     * Getter for HitBox.
     */
    @Override
    public HitBox getHitBox() {
        return hb;
    }

    /**
     * Setter for HitBox.
     */
    @Override
    public void setHitBox(final HitBox h) {
        hb = h;
    }

    /**
     * Getter for image.
     */
    @Override
    public ImageType getImageType() {
        return img;
    }

    /**
     * Getter for velocity of entity.
     */
    @Override
    public double getVel() {
        return vel;
    }

    /**
     * Setter for velocity of entity.
     */
    @Override
    public void setVel(final double vel) {
        this.vel = vel;
    }
}
