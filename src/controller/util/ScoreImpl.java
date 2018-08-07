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
     * @param name of the player;
     * @param point the player has made.
     * @param time elapsed to win the game.
     */
    public ScoreImpl(final String name, final int point, final Time time) {
        this.name = name;
        this.point = point;
        this.time = time;
    }

    /**
     * Override of toString() method.
     */
    @Override
    public String toString() {
        return name + " " + point + " " + time;
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

    /**
     * Get time elapsed to win the game.
     */
    @Override
    public Time getTime() {
        return this.time;
    }

    /**
     * To compare score of two players.
     */
    @Override
    public int compareTo(final Score player) {
        if (this.point == player.getPoint()) {
            return player.getTime().getTimeInSeconds() - this.time.getTimeInSeconds();
        }
        return this.point - player.getPoint();
    }
}
