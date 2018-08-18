package model.inanimated;

import model.hitbox.HitBox;
import utility.ImageType;

/**
 * Velocity power up item.
 */
public class VelocityUpImpl extends AbstractPowerUp implements VelocityUp {

    private static final double VEL = 10;

    /**
     * Constructor for this class.
     * 
     * @param h
     *            hb.
     */
    public VelocityUpImpl(final HitBox h) {
        super(h, ImageType.SPEED_UP);
    }

    /**
     * @return the effect of the item.
     */
    @Override
    public int getSpecificEffect() {
        final Double d = new Double(VelocityUpImpl.VEL);
        return d.intValue();
    }
}
