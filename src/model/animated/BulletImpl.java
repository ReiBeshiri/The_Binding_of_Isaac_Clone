package model.animated;

import model.hitbox.CircleHitBox;
import model.strategy.MovementStrategy;
import utility.ImageType;

/**
 * 
 * Class for all the bullets fired in the game.
 *
 */
public class BulletImpl extends AbstractAnimated implements Bullet {

    private double range;
    private final int damage;
    private final MovementStrategy bulletMS;

    /**
     * Constructor that initialize the common variables.
     * 
     * @param chb
     *            The HitBox of the bullet.
     * @param vel
     *            The speed of the bullet.
     * @param bulletMS
     *            The movement of the bullet.
     * @param range
     *            The range of the bullet.
     * @param bulletImg
     *            The bullet image.
     * @param damage
     *            Bullet damage.
     */
    public BulletImpl(final CircleHitBox chb, final double vel, final MovementStrategy bulletMS, final double range,
            final ImageType bulletImg, final int damage) {
        super(vel, chb, bulletImg);
        this.bulletMS = bulletMS;
        this.range = range;
        this.damage = damage;
    }

    /**
     * Return if bullet is dead.
     */
    @Override
    public boolean isDead() {
        return range <= 0;
    }

    /**
     * Damage of the bullet.
     */
    @Override
    public int getDamage() {
        return damage;
    }

    /**
     * Movement of entity.
     */
    @Override
    protected void move(final double dt) {
        range -= getVel() * dt;
        setHitBox(bulletMS.move(dt, getVel(), (CircleHitBox) getHitBox()));
    }
}
