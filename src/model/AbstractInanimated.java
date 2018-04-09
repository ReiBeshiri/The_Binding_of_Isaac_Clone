package model;

import model.hitbox.HitBox;
/**
 * 
 * Abstract class for inanimate entity.
 *
 */
public abstract class AbstractInanimated extends AbstractGameObject implements Inanimated {
    private boolean enable;
    /**
     * 
     * @param h HitBox.
     * @param enable State of the object.
     */
    public AbstractInanimated(final HitBox h, final boolean enable) {
        super(h);
        this.enable = enable;
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
