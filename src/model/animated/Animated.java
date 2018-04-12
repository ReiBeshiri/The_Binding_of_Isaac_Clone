package model.animated;

import model.GameObject;

/**
 * 
 *
 */
public interface Animated extends GameObject {
    /**
     * 
     * @return Return velocity of the specific object.
     */
    double getVel();

    /**
     * 
     * @param vel
     *            Set the velocity of a specific object.
     */
    void setVel(double vel);

    /**
     * 
     * @param dt
     *            DeltaTime to update position depending of time.
     * 
     */
    void update(int dt);

}