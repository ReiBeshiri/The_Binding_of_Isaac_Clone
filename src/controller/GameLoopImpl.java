package controller;

public class GameLoopImpl implements GameLoop, Runnable{
    private static final int SECONDNANO = 1000000000;
    private static final int FPS = 60;
    private boolean running;
    private Thread thread;
    private int optimalTime; //A cosa serve?
    private long lastLoop;
    /**
     * 
     */
    @Override
    public void start() {
        if (!running) {
            this.running = true;
            optimalTime = GameLoopImpl.SECONDNANO / GameLoopImpl.FPS;
            thread = new Thread();
            this.lastLoop = System.nanoTime();
            thread.run();
        }
    }

    @Override
    public void stop() {
        
    }

    @Override
    public boolean isRunning() {
        return this.running;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }

}
