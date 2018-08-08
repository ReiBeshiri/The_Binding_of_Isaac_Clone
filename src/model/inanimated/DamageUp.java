package model.inanimated;

/**
 *
 */
public interface DamageUp  extends Inanimated {

    /**
     * @return the cost of the DamageUp.
     */
    int getCost();

    /**
     * @return the amount of damage to increase.
     */
    int getDamage();
}
