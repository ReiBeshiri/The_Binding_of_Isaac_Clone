package model;

import model.hitbox.HitBox;
/**
 * 
 * Abstract class for inanimate entity.
 *
 */
public abstract class AbstractInanimated implements GameObject {
    private HitBox hitBox;
    private boolean enable;
    /**
     * 
     * @param h HitBox.
     * @param enable State of the object.
     */
    public AbstractInanimated(final HitBox h, final boolean enable) {
        this.hitBox = h;
        this.enable = enable;
    }
    /**
     * getHitBox.
     */
    @Override
    public HitBox getHitBox() {
        return hitBox;
    }
    /**
     * setHitBox.
     */
    @Override
    public void setHitBox(final HitBox h) { //ci va? dopo che l'inizializzo la prima volta non cambia piu?
        hitBox = h;
    }
    /**
     * 
     * @return Return if the Object is enable or not.
     */
    protected boolean isEnable() {
        return this.enable;
    }
    /**
     * 
     * @param enable State of the object.
     */
    protected void setEnable(final boolean enable) {
        this.enable = enable;
    }
}
