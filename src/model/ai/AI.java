package model.ai;

import java.util.Collection;

import model.animated.Bullet;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import model.strategy.MovementStrategy;
import model.strategy.ProjectileType;

/**
 * Interface that represent AI for entity in game. This interface encapsulate
 * the movement logic and the shoot logic.
 * 
 * Note: For extension we can use a setter method for change the movement
 * strategy or to change the bullet strategy. In this way you can give dynamic
 * behaviour to enemy.
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
     * @param range
     *            Range of bullet.
     * @return The collection of bullet shooted by entity.
     */
    Collection<Bullet> shoot(HitBox hBox, double vel, double range);
    /**
     * Set new type of movement.
     * @param mS New movement strategy.
     */
    void setMovementStrategy(MovementStrategy mS);
    /**
     * 
     * @param pT New projectile type.
     */
    void setProjectileType(ProjectileType pT);
    /**
     * 
     * @param life Remain life.
     */
    void nextPhaseStrategy(int life);
}
