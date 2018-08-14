package model;

import model.hitbox.HitBox;
import utility.ImageType;

/**
 * Game object interface. 
 * Root of all elements in the game.
 *
 */
public interface GameObject {

    /**
     * Getter for object hit box.
     * 
     * @return The hitBox of object.
     */
    HitBox getHitBox();

    /**
     * Setter for object hit box.
     * 
     * @param h
     *            HitBox that contains object.
     */
    void setHitBox(HitBox h);

    /**
     * Return image for this object.
     * 
     * @return Image for this object.
     */
    ImageType getImageType();
}
