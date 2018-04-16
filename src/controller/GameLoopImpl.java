package controller;

import java.util.Set;

import input.Command;
import model.World;
/**
 * 
 * Defines all the operation to update the model and pass model object 
 * to the view.
 */
public class GameLoopImpl implements GameLoop, Runnable {
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
    public void start() {
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
            final double delta = (now - this.lastLoop) / ((double) GameLoopImpl.SECONDNANO / 60); //Avanzo di tempo tra un frame e il successivo?
            this.world.update(delta, list); //Da finire;
        }
    }
    /**
     * 
     */
    @Override
    public void update(double delta, Set<Command> shoots, Set<Command> movements) {
        
    }

}
