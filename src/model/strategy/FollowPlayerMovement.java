package model.strategy;

import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import utility.ModelUtility;

/**
 * Class that represent the movement of aimed bullet or enemy.
 * 
 */
public class FollowPlayerMovement implements MovementStrategy {
    private static final int PLANE_ANGLE = 180;

    /**
     * Move the entity to next step.
     */
    @Override
    public HitBox move(final double dt, final double vel, final CircleHitBox h) {
        final double angle = Math.toDegrees(Math.atan2(ModelUtility.getPlayerHitBox().getY() - h.getY(),
                ModelUtility.getPlayerHitBox().getX() - h.getX()));
        final double deltaX = Math.sin(angle * Math.PI / PLANE_ANGLE);
        final double deltaY = Math.cos(angle * Math.PI / PLANE_ANGLE);
        return new CircleHitBox(h.getX() + deltaX, h.getY() + deltaY, h.getRadius());
    }
}
