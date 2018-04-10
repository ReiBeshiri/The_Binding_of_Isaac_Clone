package model.gameobject.inanimated;

import model.hitbox.HitBox;
/**
 * 
 * Abstract class for inanimate entity.
 *
 */
public abstract class AbstractInanimated implements Inanimated {
    private boolean enable;
    private HitBox hitBox;
    /**
     * 
     * @param h HitBox.
     * @param enable State of the object.
     */
    public AbstractInanimated(final HitBox h, final boolean enable) {
        this.enable = enable;
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
    /**
     * Return HitBox.
     */
    @Override
    public HitBox getHitBox() {
        return this.hitBox;
    }
    /**
     * Set HitBox.
     */
    @Override
    public void setHitBox(final HitBox h) {
        this.hitBox = h;
    }
}
