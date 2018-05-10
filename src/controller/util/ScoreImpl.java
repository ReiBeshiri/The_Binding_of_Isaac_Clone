package controller.util;
/**
 * Class for the score of the player.
 */
public class ScoreImpl implements Score {
    private final String name;
    private final int point;
    /**
     * 
     * @param name the name of the player;
     * @param point the point that the player has made.
     */
    public ScoreImpl(final String name, final int point) {
        this.name = name;
        this.point = point;
    }
    /**
     * Override of the method toString().
     */
    @Override
    public String toString() {
        return this.name + " " + this.point;
    }
}
