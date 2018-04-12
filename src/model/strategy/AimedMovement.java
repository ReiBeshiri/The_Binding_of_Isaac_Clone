package model.strategy;

import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
/**
 * Class that represent the movement of aimed bullet or enemy.
 * 
 */
public class AimedMovement implements MovementStrategy {
    private final HitBox target;
    /**
     * Where to shot.
     * @param t Target hitbox.
     */
    public AimedMovement(final HitBox t) {
        target = t;
    }
    /**
     * 
     */
    @Override
    public HitBox move(final int dt, final double vel, final CircleHitBox h) {
        // TODO Auto-generated method stub
        return null;
    }

}
