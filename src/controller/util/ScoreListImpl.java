package controller.util;

import java.util.List;
import java.util.stream.Collectors;
/**
 * This class implements iterator, it contains a list of Score object to iterate.
 * @param <E> Object contains name, time elapsed and score.
 */
public class ScoreListImpl<E extends Score> implements ScoreList<E> {
    private final List<E> list; 
    private int count;
    /**
     * 
     * @param ls List of Score Object;
     */
    public ScoreListImpl(final List<E> ls) {
        list = ls;
        count = -1;
    }
    /**
     * Return true if the list has another element, false otherwise.
     */
    @Override
    public boolean hasNext() {
        return count < list.size() - 1;
    }
    /**
     * Return the next element of the list.
     */
    @Override
    public E next() {
        count = count + 1;
        return list.get(count);
    }
    /**
     * Reset the counter of the list, in this way it starts again from the head of the list.
     */
    @Override
    public void reset() {
        count = -1;
    }
    /**
     * Get names of leaderboard ordered by score.
     */
    @Override
    public List<String> getNameList() {
        return list.stream().map(x -> x.getName()).collect(Collectors.toList());
    }
    /**
     * Get points of leaderboard ordered by score.
     */
    @Override
    public List<Integer> getPointList() {
        return list.stream().map(x -> x.getPoint()).collect(Collectors.toList());
    }
    /**
     * Get times of leaderboard ordered by score.
     */
    @Override
    public List<String> getTimeList() {
        return list.stream().map(x -> x.getTime().toString()).collect(Collectors.toList());
    }
}
