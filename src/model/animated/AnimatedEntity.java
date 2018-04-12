package model.animated;

import model.hitbox.HitBox;
/**
 * 
 * Abstract class that acts as a filter between Animated, BulletImpl and AbstractCharacter.
 *
 */
public abstract class AnimatedEntity implements Animated {

    private double vel;
    private HitBox hb;
    /**
     * Constructor that initialize the common variables.
     * @param vel
     *          The speed of the entity.
     * @param hb
     *          The HitBox of the entity.
     */
    public AnimatedEntity(final double vel, final HitBox hb) {
       setVel(vel);
       setHitBox(hb);
    }

    @Override
    public HitBox getHitBox() {
        return hb;
    }

    @Override
    public void setHitBox(HitBox hb) {
        this.hb=hb;
        
    }

    @Override
    public double getVel() {
        return vel;
    }

    @Override
    public void setVel(double vel) {
        this.vel=vel;

    }
    /**
     * Traveled distance during the update method.
     * @param dt
     *          Delta Time.
     * @return
     *          The HitBox in the new position.
    */
    protected abstract HitBox performMove(int dt);
    
    @Override
    public void update(int dt) {
        final HitBox position = performMove(dt);
        this.hb.changePosition(position.getX(), position.getY());
    }

}
