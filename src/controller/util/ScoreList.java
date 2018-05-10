package controller.util;

import java.util.Iterator;
import java.util.List;
/**
 * This class implements iterator, it contains a list of Score object to iterate.
 * @param <E> The type of the object must extends Score.
 */
public class ScoreList<E extends Score> implements Iterator<E> {
    private List<E> list; 
    private int count;
    /**
     * 
     * @param ls List of Score Object;
     */
    public ScoreList(final List<E> ls) {
        list = ls;
        count = -1;
    }
    /**
     * Return true if the list has another object, false otherwise.
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
     * Reset the counter of the list, in this way it starts again from the beginning of the list.
     */
    public void reset() {
        count = -1;
    }
}
