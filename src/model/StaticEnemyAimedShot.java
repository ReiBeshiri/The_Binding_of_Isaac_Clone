package model;

import input.Command;
import model.hitbox.HitBox;
/**
 * Static Enemy that shot in a player direction.
 */
public class StaticEnemyAimedShot extends StaticEnemy {
    /**
     * 
     * @param v vel. 
     * @param life life.
     * @param h hitBox.
     */
    public StaticEnemyAimedShot(final double v, final int life, final HitBox h) {
        super(v, life, h);
    }
    /**
     * 
     */
    @Override
    protected Bullet shot(final Command direction) {
        return null;
    }

}
