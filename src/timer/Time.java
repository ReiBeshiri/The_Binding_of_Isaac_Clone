package timer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public class Time {
    private static final int S_MAX = 59;
    private static final int M_MAX = 59;
    private static final int SECONDS_IN_A_MINUTE = 60;

    private int minutes, seconds;
    private final List<TimeEventListener> listeners;
    /**
     * Constructor for a time.
     * @param m Minutes;
     * @param s Seconds.
     */
    public Time(final int m, final int s) {
        minutes = m;
        seconds = s;
        listeners = new ArrayList<>();
    }
    /**
     * Inc time and notify listeners.
     */
    public void incTime() {
        if (seconds < S_MAX) {
            seconds++;
        } else if (minutes < M_MAX) {
            seconds = 0;
            minutes++;
        }
        notifyEvent(new TimeEvent(this));
    }
    /**
     * Get minutes.
     * @return Minutes.
     */
    public int getMinutes() {
        return minutes;
    }
    /**
     * Get actual seconds.
     * @return Actual seconds.
     */
    public int getSeconds() {
        return seconds;
    }
    /**
     * Get time converted in seconds.
     * @return Seconds elapsed.
     */
    public int getTimeInSeconds() {
        return seconds + minutes * SECONDS_IN_A_MINUTE;
    }
    private void notifyEvent(final TimeEvent time) {
        listeners.stream().forEach(x -> x.notifyChange());
    }
    /**
     * Add lister for timer.
     * @param l Listener.
     */
    public void addListener(final TimeEventListener l) {
        listeners.add(l);
    }
    
    public String toString() {
        return Integer.toString(minutes) + ":" + Integer.toString(seconds);
        
    }

}
