package model.inanimated;

import model.hitbox.HitBox;
import utility.ImageType;

/**
 * Heart item implements.
 */
public class HeartImpl extends AbstractPowerUp implements Heart {

    private static final int LIFE = 1;

    /**
     * Constructor for this class.
     * 
     * @param h
     *            HitBox.
     */
    public HeartImpl(final HitBox h) {
        super(h, ImageType.POWERUP_HEALTH);
    }

    /**
     * @return the effect of the item.
     */
    @Override
    public int getSpecificEffect() {
        return HeartImpl.LIFE;
    }
}
