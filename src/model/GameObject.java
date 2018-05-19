package model;

import model.hitbox.HitBox;
import proxyutility.ImageType;

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

    /**
     * Return image for this object.
     * @return Image for this object.
     */
    ImageType getImageType();
}
