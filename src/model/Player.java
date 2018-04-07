package model;

import input.Command;
import model.hitbox.HitBox;

/**
 * 
 *
 */
public class Player extends AbstractCharacter {
    /**
     * 
     * @param v
     *            Player's velocity.
     * @param life
     *            Player's life.
     * @param h
     *            HitBox.
     */
    public Player(final double v, final int life, final HitBox h) {
        super(v, life, h);
    }

    /**
     * 
     */
    @Override
    public void move(final int dt) {
//        int deltaX = 0, deltaY = 0;
//        if (movements.contains(Command.UP)) {
//            deltaY++;
//        }
//        if (movements.contains(Command.DOWN)) {
//            deltaY--;
//        }
//        if (movements.contains(Command.RIGHT)) {
//            deltaX++;
//        }
//        if (movements.contains(Command.LEFT)) {
//            deltaX--;
//        }
//        if (deltaX != 0 || deltaY != 0) {
//            // This function give the result in degrees of the angle in direction we should
//            // move.
//            final double angle = Math.toDegrees(Math.atan2(deltaY, deltaX));
//            final CircleHitBox hBox = (CircleHitBox) getHitBox();
//            // x-component and y-component of movements, using trigonometry.
//            setHitBox(new CircleHitBox(hBox.getX() + getVel() * dt * Math.sin(angle * Math.PI / PLANE_ANGLE),
//                    hBox.getY() + getVel() * dt * Math.cos(angle * Math.PI / PLANE_ANGLE), hBox.getRadius()));
//        }
    }

    /**
     * 
     */
    @Override
    public Bullet shot(final Command direction) {
        // TODO Auto-generated method stub
        return null;
    }
}
