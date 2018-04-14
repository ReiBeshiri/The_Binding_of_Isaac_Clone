package model.animated;

import java.util.Collection;

import model.ai.AI;
import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
/**
 * Class that represent generic enemy.
 *
 */
public class EnemyImpl extends AbstractCharacter implements Enemy {
    private final int points;
    /**
     * Constructor for enemy.
     * @param v Vel.
     * @param life Life.
     * @param h hitBox.
     * @param ai AI.
     * @param points Points
     */
    public EnemyImpl(final double v, final int life, final HitBox h, final AI ai, final int points) {
        super(v, life, h, ai);
        this.points = points;
    }

    /**
     * Return points.
     */
    @Override
    public int getPoint() {
        return points;
    }
    /**
     * Perform enemy movement.
     */
    @Override
    protected void move(final int dt) {
        super.getAI().move(dt, super.getVel(), (CircleHitBox) super.getHitBox());
    }
    /**
     * 
     */
    @Override
    protected Collection<Bullet> shoot() {
        return super.getAI().shoot(super.getHitBox(), super.getVel());
    }

}
