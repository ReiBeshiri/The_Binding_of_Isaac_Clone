package model.inanimated;

import model.hitbox.HitBox;
import utility.ImageType;

/**
 * Range Power Up item.
 */
public class RangeUpImpl extends AbstractPowerUp implements RangeUp {

    private static final double RANGE = 200;

    /**
     * Constructor for this class.
     * 
     * @param h
     *            hitBox.
     */
    public RangeUpImpl(final HitBox h) {
        super(h, ImageType.BULLET_RANGE_UP);
    }

    /**
     * @return the range to increase.
     */
    public double getRangeUp() {
        return getEffect();
    }

    /**
     * the effect of the item.
     */
    @Override
    public int getEffect() {
        Double d = new Double(RangeUpImpl.RANGE);
        return d.intValue();
    }

}
