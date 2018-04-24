package TimeLib;
import java.util.ArrayList;
import java.util.List;

public class Time {

	private static final int S_MAX = 59;
	private static final int M_MAX = 59;

	private int minutes, seconds;
	private final List<TimeEventListener> listeners;

	public Time(final int m, final int s) {
		minutes = m;
		seconds = s;
		listeners = new ArrayList<>();
	}

	public void incTime() {
		if ( seconds < S_MAX ) {
			seconds++;
		} else if ( minutes < M_MAX ) {
			seconds = 0;
			minutes++;
		}
		notifyEvent(new TimeEvent(this));
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}
	
	private void notifyEvent(final TimeEvent t) {
		listeners.stream().forEach(x -> x.notifyChange());
	}

	public void addListener(TimeEventListener l) {
		listeners.add(l);
	}

}
