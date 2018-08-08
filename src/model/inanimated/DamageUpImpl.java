package model.inanimated;

import model.hitbox.HitBox;
import utility.ImageType;
/**
 * Damage item implement.
 */
public class DamageUpImpl extends AbstractInanimated implements DamageUp {
    private static final int COST = 500;
    private static final int DAMAGE = 2;
    private final ImageType imgDamage;
    /**
     * 
     * @param h hb.
     * @param enable true.
     */
    public DamageUpImpl(final HitBox h, final boolean enable) {
        super(h, enable);
        imgDamage = ImageType.DAMAGE_UP;
    }

    /**
     * @return the image of the dmgUp.
     */
    @Override
    public ImageType getImageType() {
        return imgDamage;
    }

    /**
     * @return cost of the power up.
     */
    @Override
    public int getCost() {
        return COST;
    }

    /**
     * @return the damage to increase.
     */
    @Override
    public int getDamage() {
        return DAMAGE;
    }

}
