package model.inanimated;

import model.hitbox.HitBox;
import proxyutility.ImageType;
/**
 * 
 * Heart implements.
 *
 */
public class HeartImpl extends AbstractInanimated implements Heart {

    private static final int COST = 500;
    private static final int LIFE = 1;
    private final ImageType imgHearth;

    //All'inizio il "bottone" non sarà attivo perchè la vita sarà gia piena,
    //ma appena si perde vita bisogna attivarlo.
    /**
     * 
     * @param h HitBox.
     * @param enable It's possible buy the life.
     */
    public HeartImpl(final HitBox h, final boolean enable) {
        super(h, enable);
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

}
