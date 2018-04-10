package model.strategy;

import java.util.List;

import input.Command;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
/**
 * Movement for player.
 *
 */
public class PlayerMovement implements MovementStrategy {
    private static final double PLANE_ANGLE = 180;
    /**
     * Method that perform Player Movement.
     */
    @Override
    public HitBox move(final int dt, final double vel, final CircleHitBox h) {
        final List<Command> list /*= ModelUtilities().getInputCommandList()*/;
        int deltaX = 0, deltaY = 0;
        if (list.contains(Command.UP)) {
            deltaY++;
        }
        if (list.contains(Command.DOWN)) {
            deltaY--;
        }
        if (list.contains(Command.RIGHT)) {
            deltaX++;
        }
        if (list.contains(Command.LEFT)) {
            deltaX--;
        }
        if (deltaX != 0 || deltaY != 0) {
            // This function give the result in degrees of the angle in direction we should
            // move.
            final double angle = Math.toDegrees(Math.atan2(deltaY, deltaX));
            // x-component and y-component of movements, using trigonometry.
            // With "angle * Math.PI / PLANE_ANGLE" we convert angle by degrees (obtained by conversion of atan2 result)
            // to radiant. 
            final double performedX = h.getX() * vel * dt * Math.sin(angle * Math.PI / PLANE_ANGLE);
            final double performedY = h.getY() * vel * dt * Math.cos(angle * Math.PI / PLANE_ANGLE);
            return new CircleHitBox(performedX, performedY, h.getRadius());
        } 
        //If anything command was pressed in this frame, return the old HitBox, 
        //in the last position.
        return h;
    }
    /*
     * | \
     * | a \
     * |     \ 
     * |       \ speed.
     * | y       \
     * |           \
     * |     x       \
     * |_______________\
     *       x --> speed * sen(a);
     *       y --> speed * cos(a);
     */
}
