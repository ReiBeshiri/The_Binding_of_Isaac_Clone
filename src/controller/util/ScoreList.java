package controller.util;

import java.util.Iterator;
import java.util.List;
/**
 * 
 *
 * @param <E>
 */
public interface ScoreList<E extends Score> extends Iterator<E> {
    /**
     * Return a boolean if the list has another element.
     * @return true if the list has another element, false otherwise.
     */
    boolean hasNext();
    /**
     * Return the next element of the list.
     * @return a Score element.
     */
    E next();
    /**
     * Reset the counter of the list, in this way it starts again from the head of the list.
     */
    void reset();
    /**
     * Get names of leaderboard ordered by score.
     * @return the list of names in the leaderboard.
     */
    List<String> getNameList();
    /**
     * Get points of leaderboard ordered by score.
     * @return the list of points in the leaderboard.
     */
    List<Integer> getPointList();
    /**
     * Get times of leaderboard ordered by score.
     * @return the list of points in the leaderboard.
     */
    List<String> getTimeList();
}
