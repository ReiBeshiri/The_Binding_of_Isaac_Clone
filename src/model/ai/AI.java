package model.ai;

import java.util.Collection;

import model.animated.Bullet;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;

/**
 * Interface that represent AI for entity in game. This interface encapsulate
 * the movement logic and the shoot logic.
 * 
 * Note: For extension we can use a setter method for change the movement
 * strategy or to change the bullet strategy.
 */
public interface AI {
    /**
     * Method that realize movement.
     * 
     * @param dt
     *            DeltaTime.
     * @param vel
     *            Velocity.
     * @param hBox
     *            HitBox.
     * @return HitbBox of entity in the new position.
     */
    HitBox move(int dt, double vel, CircleHitBox hBox);

    /**
     * Return the collections of bullet shooted by entity.
     * 
     * @param hBox
     *            HitBox of entity where the bullet start.
     * @param vel
     *            Velocity.
     * @return The collection of bullet shooted by entity.
     */
    Collection<Bullet> shoot(HitBox hBox, double vel);
}
