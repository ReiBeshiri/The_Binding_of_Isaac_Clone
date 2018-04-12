package model.animated;

import java.util.Collection;

import model.ai.AI;
import model.hitbox.HitBox;

/**
 * Abstract class for character that can move or shot.
 * 
 */
public abstract class AbstractCharacterAlternative extends AnimatedEntity implements Animated{
    
    private int life;
    private final AI ai;
    
    /**
     * 
     * @param v
     *            Velocity of this object.
     * @param life
     *            Life of this player.
     * @param h
     *            HitBox of object.
     * @param ai
     *            Artificial Intelligence.
     */
    public AbstractCharacterAlternative(final double v, final int life, final HitBox h, final AI ai){
        super(v, h);
        this.life = life;
        this.ai = ai;
    }
    
    /**
     * 
     * @param dt
     *            DeltaTime to perform move.
     */
    protected abstract void move(int dt);

    /**
     * 
     * @return Collection of new Bullets, that depend on the type of enemy.
     */
    protected abstract Collection<Bullet> shot();
    
    /**
     * Return life of the entity.
     * 
     * @return Life of the entity.
     */
    public int getLife() {
        return life;
    }

    /**
     * 
     * @param dec
     *            life to dec.
     */
    public void decLife(final int dec) {
        life -= dec;
    }
    /**
     * Method to expose the AI only to subclass.
     * 
     * @return AI.
     */
    protected AI getAI() {
        return ai;
    }
}
