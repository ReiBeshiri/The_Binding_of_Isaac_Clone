package model.strategy;

import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
/**
 * Class that represent the bullet movement.
 *
 */
public class BulletMovement implements MovementStrategy {
    private static final int PLANE_ANGLE = 180;
    private final double angle;

    /**
     * Constructor for this class.
     * @param angle Movement's angle.
     */
    public BulletMovement(final double angle) {
        this.angle = angle;
    }

    /**
     * Perform movement of the bullet, using angle.
     */
    @Override
    public HitBox move(final double dt, final double vel, final CircleHitBox h) {
        final double deltaX = Math.sin(angle * Math.PI / PLANE_ANGLE);
        final double deltaY = Math.cos(angle * Math.PI / PLANE_ANGLE);
        return new CircleHitBox(h.getX() + deltaX, h.getY() + deltaY, h.getRadius());
    }

}
