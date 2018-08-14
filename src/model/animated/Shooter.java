package model.animated;

import java.util.Collection;

/**
 * Interface that represent entity that can shot.
 *
 */
public interface Shooter extends LivingObject {

    /**
     * Method used to shot a collection of bullets.
     * 
     * @return collection of bullet shoted.
     */
    Collection<Bullet> shoot();

    /**
     * Setter for damage up of bullets.
     * 
     * @param damage
     *            the damage to increase.
     */
    void setDamage(int damage);

    /**
     * Set new range of bullets.
     * 
     * Note: Uses for power-up.
     * 
     * @param incRange
     *            New range for entity bullets.
     */
    void setRange(double incRange);

    /**
     * Return if entity can shot.
     * 
     * @return ratio if entity can shot.
     */
    boolean canShot();

    /**
     * Method used to increment attend time.
     * 
     * @param val
     *            value to increase.
     */
    void incAttendTime(double val);

    /**
     * Getter for bullet vel.
     * 
     * @return bullet vel.
     */
    double getBulletVel();

    /**
     * Getter for bullet range.
     * 
     * @return bullet range.
     */
    double getBulletRange();

    /**
     * Getter for bullet radius.
     * 
     * @return bullet radius.
     */
    double getBulletRadius();

    /**
     * Getter for bullet damage.
     * 
     * @return bullet damage.
     */
    int getBulletDamage();
}
