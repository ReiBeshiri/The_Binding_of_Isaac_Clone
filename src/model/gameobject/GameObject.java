package model;

import model.hitbox.HitBox;

/**
 * 
 *
 */
public interface GameObject {
    /**
     * 
     * @return The hitBox of object.
     */
    HitBox getHitBox();

    /**
     * 
     * @param h
     *            HitBox that contains object.
     */
    void setHitBox(HitBox h);
}
