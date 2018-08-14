package model.inanimated;

import model.hitbox.HitBox;
import utility.ImageType;

/**
 * Velocity power up item.
 */
public class VelocityUpImpl implements VelocityUp {

    private static final int COST = 5000;
    private static final double VEL = 10;

    private final HitBox hitBox;
    private final ImageType imgVelocity;

    /**
     * Constructor for this class.
     * 
     * @param h
     *            hb.
     */
    public VelocityUpImpl(final HitBox h) {
        hitBox = h;
        imgVelocity = ImageType.SPEED_UP;
    }

    /**
     * @return the img of the item.
     */
    @Override
    public ImageType getImageType() {
        return imgVelocity;
    }

    /**
     * @return the cost of the item.
     */
    @Override
    public int getCost() {
        return COST;
    }

    /**
     * @return the speed to increase.
     */
    @Override
    public double getVelocity() {
        return VEL;
    }

    /**
     * Getter for HitBox.
     */
    @Override
    public HitBox getHitBox() {
        return hitBox;
    }

    /**
     * Set HitBox.
     * Not used for power up.
     */
    @Override
    public void setHitBox(final HitBox h) { }
}
