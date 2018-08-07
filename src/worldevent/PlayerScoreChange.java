package worldevent;
/**
 * Whenever the player pick up an object from the shop or gets hit.
 */
public class PlayerScoreChange implements WorldEvent {
    private int points;

    /**
     * @param p point to decrease.
     */
    public PlayerScoreChange(final int p) {
        points = p;
    }

    /**
     * @return points to decrease.
     */
    public int getPoints() {
        return points;
    }
}
