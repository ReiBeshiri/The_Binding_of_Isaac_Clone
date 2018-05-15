package controller.util;

import timer.Time;

/**
 * Interface for score object.
 */
public interface Score {
    /**
     * Get player's name.
     * @return the name of the player.
     */
    String getName();
    /**
     * Get player's point.
     * @return player's point.
     */
    int getPoint();
    /**
     * Get the time elapsed to win the game.
     * @return time elapsed for win the game.
     */
    Time getTime();
}
