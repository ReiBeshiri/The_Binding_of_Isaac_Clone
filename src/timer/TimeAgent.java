package timer;

/**
 * Class used to implement thread for timer of the game.
 *
 */
public class TimeAgent implements Runnable {

    private final Time time;
    private boolean stop;

    /**
     * Constructor for the timer.
     * @param t initial time for timer.
     */
    public TimeAgent(final Time t) {
        time = t;
        stop = false; 
    }

    /**
     * Run method of thread.
     */
    @Override
    public void run() {
        while (!stop) {
            time.incTime();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Interrupt event, that stop thread.
     */
    public void interrupt() {
        stop = true;
    }

    /**
     * Return if thread is running.
     * @return is thread is running.
     */
    public boolean isRunning() {
        return !stop;
    }
}
