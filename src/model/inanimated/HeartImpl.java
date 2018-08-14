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
     * Return the amount of life that the heart gives.
     */
    @Override
    public int getLife() {
        return HeartImpl.LIFE;
    }

}
