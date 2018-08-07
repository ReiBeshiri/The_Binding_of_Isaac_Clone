package model.inanimated;

import model.hitbox.HitBox;
import proxyutility.ImageType;

/**
 * Range Power Up.
 */
public class RangeUpImpl extends AbstractInanimated implements RangeUp {
    private static final int COST = 500;
    private static final double RANGE = 200;
    private final ImageType imgRangeUp;
    private boolean taken = false;

    /**
     * @param h
     *            hb.
     * @param enable
     *            .
     */
    public RangeUpImpl(final HitBox h, final boolean enable) {
        super(h, enable);
        imgRangeUp = ImageType.ICON;
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
        if (!taken) {
            return RANGE;
        } else {
            return 0;
        }
    }

}
