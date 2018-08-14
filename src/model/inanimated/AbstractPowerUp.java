package model.inanimated;

import model.hitbox.HitBox;
import utility.ImageType;

/**
 * Abstract Class for power ups.
 */
public abstract class AbstractPowerUp implements PowerUp {

    private static final int COST = 5000;

    private final HitBox hb;
    private final ImageType img;

    /**
     * Constructor for this class.
     * 
     * @param hb
     *            HitBox.
     * @param img
     *            Image.
     */
    public AbstractPowerUp(final HitBox hb, final ImageType img) {
        this.hb = hb;
        this.img = img;
    }

    /**
     * @return hb;
     */
    @Override
    public HitBox getHitBox() {
        return hb;
    }

    /**
     * Does nothing, can't reset hb of an inanimate obj.
     * 
     * @param h
     *            the hb.
     */
    @Override
    public void setHitBox(final HitBox h) {
    }

    /**
     * @return the image of the item.
     */
    @Override
    public ImageType getImageType() {
        return img;
    }

    /**
     * @return the cost of the object.
     */
    @Override
    public int getCost() {
        return COST;
    }

    /**
     * @return the effect of the item.
     */
    public abstract int getEffect();

}
