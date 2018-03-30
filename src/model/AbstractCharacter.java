package model;

import java.util.List;

/**
 * Abstract class for character that can move or shot.
 * 
 */
public abstract class AbstractCharacter implements Animated {
    private final double velocity;
    private final int life;

    /**
     * 
     * @param v
     *            Velocity of this object.
     * @param life
     *            Life of this player.
     */
    public AbstractCharacter(final double v, final int life) {
        velocity = v;
        this.life = life;
    }

    /**
     * 
     * @param dt
     */
    protected abstract void move(int dt);

    protected abstract Bullet shot();

    /**
     * 
     */
    @Override
    public double getVel() {
        return velocity;
    }

    /**
     * 
     */
    @Override
    public void setVel(final double vel) {
        velocity = vel;
    }

    /**
     * 
     */
    @Override
    public void update(final int dt, final List<Command> movements) {

    }

    /**
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
}
