package model.inanimated;
/**
 * Velocity Up item interface.
 */
public interface VelocityUp extends Inanimated {

    /**
     * @return the cost of the item.
     */
    int getCost();

    /**
     * @return the amount of velocity to increase.
     */
    double getVelocity();
}
