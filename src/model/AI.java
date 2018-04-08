package model;

import java.util.Collection;

import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
/**
 * Interface that represent AI for entity in game. 
 * This interface encapsulate the movement logic and the shoot logic. 
 *
 */
public interface AI {
    /**
     * Method that realize movement.
     * @param dt DeltaTime.
     * @param vel Velocity.
     * @param hBox HitBox.
     * @return HitbBox of entity in the new position.
     */
    HitBox move(int dt, int vel, CircleHitBox hBox);
    /**
     * Return the collections of bullet shooted by entity. 
     * @param hBox HitBox of entity where the bullet start.
     * @param vel Velocity.
     * @param nBulletToShoot  Number of bullet to shoot.
     * @return The collection of bullet shooted by entity.
     */
    Collection<Bullet> shoot(HitBox hBox, int vel, int nBulletToShoot);
}
