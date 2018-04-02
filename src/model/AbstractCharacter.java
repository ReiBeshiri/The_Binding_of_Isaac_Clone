package model;

import java.util.List;

import input.Command;

/**
 * Abstract class for character that can move or shot.
 * 
 */
public abstract class AbstractCharacter implements Animated {
    private double velocity;
    private int life;

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
     *            DeltaTime to perform move.
     * @param movements
     *            List of pressed keys for movements.
     */
    protected abstract void move(int dt, List<Command> movements);

    /**
     * 
     * @param direction
     *            Direction where bullet need to spawn.
     * @return new Bullet, that depend on the type of enemy.
     */
    protected abstract Bullet shot(Command direction);

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
        move(dt, movements);
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
