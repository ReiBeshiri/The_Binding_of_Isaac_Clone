package model.inanimated;

/**
 * Power up item for damage.
 */
public interface DamageUp extends PowerUp {

    /**
     * Getter for damage bonus obtained by item.
     * 
     * @return the amount of damage to increase.
     */
    int getDamage();
}
