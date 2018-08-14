package model.inanimated;

import model.hitbox.HitBox;
import utility.ImageType;

/**
 * Range Power Up item.
 */
public class RangeUpImpl implements RangeUp {

    private static final int COST = 5000;
    private static final double RANGE = 200;

    private final HitBox hitBox;
    private final ImageType imgRangeUp;

    /**
     * Constructor for this class.
     * 
     * @param h
     *            hitBox.
     */
    public RangeUpImpl(final HitBox h) {
        hitBox = h;
        imgRangeUp = ImageType.BULLET_RANGE_UP;
    }

    /**
     * @return the image of the power up.
     */
    @Override
    public ImageType getImageType() {
        return imgRangeUp;
    }

    /**
     * The cost of the power up.
     */
    @Override
    public int getCost() {
        return COST;
    }

    /**
     * The range to increase.
     */
    @Override
    public double getRangeUp() {
        return RANGE;
    }

    /**
     * Getter for hitBox.
     */
    @Override
    public HitBox getHitBox() {
        return hitBox;
    }

    /**
     * Setter for hitBox.
     * Not used in powerUp.
     */
    @Override
    public void setHitBox(final HitBox h) { }
}
