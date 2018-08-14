package model.inanimated;

import model.hitbox.HitBox;
import utility.ImageType;

/**
 * Damage item implement.
 */
public class DamageUpImpl extends AbstractPowerUp implements DamageUp {

    private static final int DAMAGE = 2;


    /**
     * Constructor for this class.
     * 
     * @param h
     *            hb.
     */
    public DamageUpImpl(final HitBox h) {
        super(h, ImageType.DAMAGE_UP);
    }

    /**
     * @return the damage to increase.
     */
    public int getDamage() {
        return getEffect();
    }

    /**
     * @return the effect of the item.
     */
    @Override
    public int getEffect() {
        return DamageUpImpl.DAMAGE;
    }

}
