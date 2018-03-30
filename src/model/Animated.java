package model;

import java.util.List;

import input.Command;

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
     * @param movements
     *            list of movements pressed from the player.
     */
    void update(int dt, List<Command> movements);

}
