package model;

import input.Command;
import model.hitbox.HitBox;
/**
 * Enemy that shot in a static direction.
 *
 */
public class StaticEnemyBasicShot extends StaticEnemy {
    /**
     * 
     * @param v vel.
     * @param life life.
     * @param h hitBox.
     */
    public StaticEnemyBasicShot(final double v, final int life, final HitBox h) {
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
