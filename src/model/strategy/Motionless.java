package model.strategy;

import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
/**
 * Class that represnet static movement.
 *
 */
public class Motionless implements MovementStrategy {
    /**
     * 
     */
    @Override
    public HitBox move(final int dt, final double vel, final CircleHitBox h) { 
        return h;
    }

}
