package model;
/**
 * 
 *
 */
public class Player extends AbstractCharacter {
    /**
     * 
     * @param v Player's velocity.
     * @param life Player's life.
     */
    public Player(final double v, final int life) {
        super(v, life);
    }
    /**
     * 
     */
    @Override
    protected void move(final int dt) {
        //TODO Use list of command pressed to perform move.
    }

}
