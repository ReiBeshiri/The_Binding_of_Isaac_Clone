package controller.util;

import timer.Time;

/**
 * Class for the score of the player.
 */
public class ScoreImpl implements Score {
    private final String name;
    private final int point;
    private final Time time;
    /**
     * 
     * @param name the name of the player;
     * @param point the point that the player has made.
     */
    public ScoreImpl(final String name, final int point, final Time time) {
        this.name = name;
        this.point = point;
        this.time = time;
    }
    /**
     * Override of the method toString().
     */
    @Override
    public String toString() {
        return this.name + " " + this.point;
    }
    /**
     * Get player's name.
     */
    @Override
    public String getName() {
        return this.name;
    }
    /**
     * Get player's point.
     */
    @Override
    public int getPoint() {
        return this.point;
    }
}
