package model;

import input.Command;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import static input.Command.UP;
import static input.Command.DOWN;
import static input.Command.RIGHT;

/**
 * This class represent the horizontal movement of a enemy or a shoot.
 * 
 */
public class SimplyDirectionMovement implements MovementStrategy {
    private Command moveDirection;

    /**
     * 
     * @param dir
     *            Direction to perform movement.
     */
    public SimplyDirectionMovement(final Command dir) {
        moveDirection = dir;
    }

    /**
     * Method to apply horizontal movement. Note: Different from the player
     * movements, instead, we can't have two movements "pressed" in the same time.
     */
    @Override
    public HitBox move(final int dt, final double vel, final CircleHitBox h) {
        int x = 0, y = 0;
        if (moveDirection == UP) {
            y++;
        } else if (moveDirection == DOWN) {
            y--;
        } else if (moveDirection == RIGHT) {
            x++;
        } else {
            x--;
        }
        if (x != 0) {
            final double deltaX = vel * dt * Math.sin(moveDirection.getAngle());
            return new CircleHitBox(h.getX() + deltaX, h.getY(), h.getRadius());
        } else if (y != 0) {
            final double deltaY = vel * dt * Math.cos(moveDirection.getAngle());
            return new CircleHitBox(h.getX(), h.getY() + deltaY, h.getRadius());
        }
        return h;
    }

    /**
     * Getter for movement direction.
     * 
     * @return The movement direction.
     */
    public Command getMoveDirection() {
        return moveDirection;
    }

    /**
     * If a enemy that use this type of movement and collide with the border we need
     * that he change his direction. Note: Otherwise if it is a bullet doesn't need
     * to use this method, but simply disappear.
     */
    public void reverseMovementDirection() {
        moveDirection = moveDirection.getOppositeCommand();
    }
}
