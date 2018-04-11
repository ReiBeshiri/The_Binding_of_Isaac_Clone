package model.hitbox;

/**
 * 
 *
 */
public interface HitBox {
    /**
     * Changes the coordinates of a HitBox.
     * 
     * @param x
     *          X Coordinate.
     * @param y
     *          Y Coordinate.
     */
    void changePosition(double x, double y);
    /**
     * Get X of center of HitBox.
     * 
     * @return X coordinate.
     */
    double getX();

    /**
     * Get Y of center of HitBox.
     * 
     * @return Y coordinate.
     */
    double getY();
}
