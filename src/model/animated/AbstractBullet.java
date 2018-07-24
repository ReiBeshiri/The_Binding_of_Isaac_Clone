package model.animated;

import java.util.Collection;
import java.util.Collections;
import model.hitbox.HitBox;
import proxyutility.ImageType;
/**
 * 
 * Abstract class that acts as a filter between Animated and BulletImpl.
 *
 */
public abstract class AbstractBullet implements Animated {

    private double vel;
    private HitBox hb;
    private final ImageType img;

    /**
     * Constructor that initialize the common variables.
     * @param vel
     *          The speed of the entity.
     * @param hb
     *          The HitBox of the entity.
     * @param img
     *          Image for the bullet.
     */
    public AbstractBullet(final double vel, final HitBox hb, final ImageType img) {
       this.vel = vel;
       this.hb = hb;
       this.img = img;
    }
    /**
     * 
     */
    @Override
    public HitBox getHitBox() {
        return hb;
    }
    /**
     * 
     */
    @Override
    public void setHitBox(final HitBox hb) {
        this.hb = hb;
    }
    /**
     * 
     */
    @Override
    public double getVel() {
        return vel;
    }
    /**
     * 
     */
    @Override
    public void setVel(final double vel) {
        this.vel = vel;

    }

    /**
     * Traveled distance during the update method.
     * @param dt
     *          Delta Time.
     * @return
     *          The HitBox in the new position.
    */
    protected abstract HitBox performMove(double dt);

    /**
     * Shot bullets of entity. (Template Method).
     * Empty because bullet can't shoot.
     */
    @Override
    public Collection<Bullet> shot() { 
        return Collections.emptyList();
    }

    /**
     * 
     */
    @Override
    public void update(final double dt) {
        final HitBox position = performMove(dt);
        this.hb.changePosition(position.getX(), position.getY());
    }
    /**
     * 
     */
    @Override
    public ImageType getImageType() {
        return this.img;
    }
}
