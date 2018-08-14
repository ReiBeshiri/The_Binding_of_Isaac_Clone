package model.inanimated;

import model.hitbox.HitBox;
import utility.ImageType;

/**
 * Damage item implement.
 */
public class DamageUpImpl implements DamageUp {

    private static final int COST = 5000;
    private static final int DAMAGE = 2;

    private final ImageType imgDamage;
    private final HitBox hitBox;

    /**
     * Constructor for this class.
     * 
     * @param h
     *            hb.
     */
    public DamageUpImpl(final HitBox h) {
        hitBox = h;
        imgDamage = ImageType.DAMAGE_UP;
    }

    /**
     * Getter for image of object.
     * 
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

    /**
     * Getter for HitBox.
     */
    @Override
    public HitBox getHitBox() {
        return hitBox;
    }

    /**
     * Setter for HitBox.
     * Not used in powerUp.
     */
    @Override
    public void setHitBox(final HitBox h) { }
}
