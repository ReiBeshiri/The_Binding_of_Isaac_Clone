package model.gameobject.animated;

/**
 * 
 *
 */
public interface Bullet extends Animated {

    /**
     * Gets the value of the range.
     * @return The range
     */
    double getRange();
    /**
     * Check if the bullet has gone out of range.
     * @return True if has gone out of range, false otherwise
     */
    boolean isDead();
}
