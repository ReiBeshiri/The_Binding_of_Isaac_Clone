package model.strategy;

import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import utility.ModelUtility;
/**
 * This class represent the aimed movement of a shoot to the player coordinates.
 * 
 */
public class AimedProjectileMovement implements MovementStrategy {
    /**
     * 
     */
    @Override
    public HitBox move(int dt, double vel, CircleHitBox h) {
        final double angle = Math.toDegrees(Math.atan2(ModelUtility.getPlayerHitBox().getY() - h.getY(),
                ModelUtility.getPlayerHitBox().getX() - h.getX()));
        final double x = vel * dt * Math.cos(Math.toRadians(angle));
        final double y = -vel * dt * Math.sin(Math.toRadians(angle));
        return new CircleHitBox(h.getX() + x, h.getY() + y, h.getRadius());
    }

}
