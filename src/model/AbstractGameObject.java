package model;

import model.hitbox.HitBox;
/**
 * Implementation of GameObject interface.
 * It can't be initialize. 
 * 
 */
public abstract class AbstractGameObject implements GameObject {
    private HitBox hitBox;
    /**
     * Constructor.
     * @param h HitBox.
     */
    public AbstractGameObject(final HitBox h) {
        hitBox = h;
    }
    /**
     * Getter for HitBox.
     */
    @Override
    public HitBox getHitBox() {
        return hitBox;
    }
    /**
     * Set HitBox of entity.
     */
    @Override
    public void setHitBox(final HitBox h) {
        hitBox = h;
    }

}
