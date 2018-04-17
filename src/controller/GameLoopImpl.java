package controller;

import model.World;
/**
 * 
 * Defines all the operation to update the model and pass model object 
 * to the view.
 */
public class GameLoopImpl implements GameLoop, Runnable {
    private static final long SECONDMICRO = 1000000;
    private static final int SECONDNANO = 1000000000;
    private static final int FPS = 60;
    private static final int MSWAIT = 5;
    private boolean running;
    private Thread thread;
    private int optimalTime; //A cosa serve?
    private long lastLoop;
    private World world;
    /**
     * 
     * @param world The instance of the model
     */
    public GameLoopImpl(final World world) {
        this.world = world;
    }
    /**
     * 
     */
    @Override
    public synchronized void start() { //Cos'è synchronized?
        if (!running) {
            this.running = true;
            optimalTime = GameLoopImpl.SECONDNANO / GameLoopImpl.FPS;
            this.lastLoop = System.nanoTime();
            thread = new Thread();
            thread.run();
        }
    }
    /**
     * 
     */
    @Override
    public void stop() {
        if (running) {
            try {
                thread.join(MSWAIT);
            } catch (InterruptedException e) {
                //How do we manage exception?
            }
        }
    }
    /**
     * 
     */
    @Override
    public boolean isRunning() {
        return this.running;
    }
    /**
     * 
     */
    @Override
    public void run() {
        while (running) {
            final long now = System.nanoTime();
            final long sleepTime;
            final double delta = (now - this.lastLoop) / ((double) GameLoopImpl.SECONDNANO / 60); //Avanzo di tempo tra un frame e il successivo?
            
            update(delta); //Da finire;
            
            
            sleepTime = (lastLoop - System.nanoTime() + optimalTime) / GameLoopImpl.SECONDMICRO;

            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (Exception e) {
                    //Cosa facciamo?
                }
            }
        }
    }
    /**
     * 
     * @param delta
     */
    private void update(final double delta) {
        world.update(delta, GameEngineImpl.get().getKeyMovementList(), GameEngineImpl.get().getKeyShootListener());
    }

}
