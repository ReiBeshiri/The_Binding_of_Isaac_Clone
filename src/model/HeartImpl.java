package model;

import model.hitbox.HitBox;
/**
 * 
 * Heart implements.
 *
 */
public class HeartImpl extends AbstractInanimated implements Heart {

    private static final int COST = 1;
    private static final int LIFE = 1;
    //All'inizio il "bottone" non sarà attivo perchè la vita sarà gia piena,
    //ma appena si perde vita bisogna attivarlo.
    /**
     * 
     * @param h HitBox.
     * @param enable It's possible buy the life.
     */
    public HeartImpl(final HitBox h, final boolean enable) {
        super(h, enable);
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

}
