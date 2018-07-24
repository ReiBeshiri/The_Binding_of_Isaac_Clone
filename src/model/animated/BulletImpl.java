package model.animated;

import model.hitbox.CircleHitBox;
import model.hitbox.HitBox;
import model.strategy.MovementStrategy;
import proxyutility.ImageType;
/**
 * 
 * Class for all the bullets fired in the game.
 *
 */
public class BulletImpl extends AbstractBullet implements Bullet {

    private double range;
    private final MovementStrategy bulletMS;

    /**
     * Constructor that initialize the common variables.
     * @param chb
     *          The HitBox of the bullet.
     * @param vel
     *          The speed of the bullet.
     * @param bulletMS
     *          The movement of the bullet.
     * @param range
     *          The range of the bullet.
     * @param bulletImg
     *          The bullet image.
     */
    public BulletImpl(final CircleHitBox chb, final double vel, final MovementStrategy bulletMS, final double range, final ImageType bulletImg) {
        super(vel, chb, bulletImg);
        this.bulletMS = bulletMS;
        this.range = range;
    }

    /**
     * 
     */
    @Override
    public double getRange() {
        return this.range;
    }

    /**
     * 
     */
    @Override
    public boolean isDead() {
        return range <= 0;
    }

    /**
     * 
     */
    @Override
    protected HitBox performMove(final double dt) {
        range -= super.getVel() * dt;
        return bulletMS.move(dt, super.getVel(), (CircleHitBox) super.getHitBox());
    }
}
