package model.animated;

import java.util.Collection;

import model.GameObject;

/**
 * Class that represent animated entities in the game.
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
    void update(double dt);

    /**
     * Method used to shot a collection of bullets.
     * @return collection of bullet shoted.
     */
    Collection<Bullet> shot();
}
