package model.animated;

/**
 * Interface that represent living objects in the game.
 *
 */
public interface LivingObject extends Animated {
    /**
     * Return life of the entity.
     * 
     * @return Life of the entity.
     */
    int getLife();

    /**
     * Decrease life.
     * 
     * @param dec
     *            life to decrease.
     */
    void decLife(int dec);

    /**
     * Increase life if entity doesn't have max life already.
     * 
     * @param inc
     *            Delta to increase life.
     */
    void incLife(int inc);
}
