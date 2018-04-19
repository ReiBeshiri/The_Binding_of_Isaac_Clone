package worldevent;

/**
 * Event generated when the player gain/lose heart points.
 */
public class PlayerHeartChange implements WorldEvent {
    private int life;
    /**
     * 
     * @param life player's life.
     */
    public PlayerHeartChange(final int life) {
        this.life = life;
    }
    /**
     * 
     * @return player's life.
     */
    public int getCurretLife() {
        return life;
    }
}
