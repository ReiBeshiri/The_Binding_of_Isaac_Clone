package model.inanimated;

/**
 * Interface that represent power up objects.
 *
 */
public interface PowerUp extends Inanimated {

    /**
     * Getter method for cost of items (in points).
     * @return the cost of the Heart.
     */
    int getCost();

    /**
     * Get effect of the power up.
     * @return the incremental effect.
     */
    int getEffect();
}
