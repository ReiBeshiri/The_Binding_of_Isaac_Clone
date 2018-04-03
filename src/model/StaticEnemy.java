package model;

import java.util.List;

import input.Command;
import model.hitbox.HitBox;
/**
 * Class that represent ememy that can't move.
 * 
 */
public abstract class StaticEnemy extends AbstractCharacter implements Enemy {
    private static final int POINTS = 5;
    /**
     * 
     * @param v velocity.
     * @param life life.
     * @param h HitBox.
     */
    public StaticEnemy(final double v, final int life, final HitBox h) {
        super(v, life, h);
    }
    /**
     * 
     */
    @Override
    public int getPoint() {
        return POINTS;
    }
    /**
     * 
     */
    @Override
    protected void move(final int dt, final List<Command> movements) { }
}
