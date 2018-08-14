package model.inanimated;

import model.hitbox.HitBox;
import utility.ImageType;

/**
 * Heart item implements.
 */
public class HeartImpl implements Heart {

    private static final int COST = 5000;
    private static final int LIFE = 1;

    private final HitBox hitBox;
    private final ImageType imgHearth;

    /**
     * Constructor for this class.
     * 
     * @param h
     *            HitBox.
     */
    public HeartImpl(final HitBox h) {
        hitBox = h;
        imgHearth = ImageType.POWERUP_HEALTH;
    }

    /**
     * Return the cost of the Heart.
     */
    @Override
    public int getCost() {
        return HeartImpl.COST;
    }

    /**
     * Return the amount of life that the heart gives.
     */
    @Override
    public int getLife() {
        return HeartImpl.LIFE;
    }

    /**
     * Return image of hearth.
     */
    @Override
    public ImageType getImageType() {
        return imgHearth;
    }

    /**
     * Getter for HitBox.
     */
    @Override
    public HitBox getHitBox() {
        return hitBox;
    }

    /**
     * Setter for HitBox.
     * Not used in this power up.
     */
    @Override
    public void setHitBox(final HitBox h) { }
}
