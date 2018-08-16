package model.strategy.movement;

import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import model.strategy.MovementStrategy;

/**
 * Class that represent static movement.
 *
 */
public class Motionless implements MovementStrategy {

    /**
     * Entity without movement.
     */
    @Override
    public HitBox move(final double dt, final double vel, final CircleHitBox h) { 
        return h;
    }

}
