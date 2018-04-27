package timer;

public class TimeAgent extends Thread {

    private Time time;
    private boolean stop = false;

    public TimeAgent(final Time t) {
        time = t;
    }

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

    public void interrupt() {
        stop = true;
    }
}
