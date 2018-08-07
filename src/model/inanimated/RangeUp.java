package model.inanimated;
/**
 *
 */
public interface RangeUp extends Inanimated {
    /**
     * cost of the power up.
     * @return the cost of the power up.
     */
    int getCost();

    /**
     * The range to increase.
     * @return the range to increase.
     */
    double getRangeUp();
}
