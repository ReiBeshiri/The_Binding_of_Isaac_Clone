package model.inanimated;

import model.hitbox.HitBox;
import utility.ImageType;

/**
 * Walls class.
 */
public class WallImpl implements Wall {

    private final ImageType imgWall;
    private final HitBox hitBox;

    /**
     * Constructor for this class.
     * 
     * @param hb
     *            HitBox
     * @param imgWall
     *            image of the wall.
     */
    public WallImpl(final HitBox hb, final ImageType imgWall) {
        hitBox = hb;
        this.imgWall = imgWall;
    }

    /**
     * Cannot set HitBox after creating the wall.
     */
    @Override
    public void setHitBox(final HitBox h) { }

    /**
     * Get Image type.
     */
    @Override
    public ImageType getImageType() {
        return this.imgWall;
    }

    /**
     * Getter for HitBox.
     */
    @Override
    public HitBox getHitBox() {
        return hitBox;
    }
}
