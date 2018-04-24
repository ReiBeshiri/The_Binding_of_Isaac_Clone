package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import controller.event.Event;
import input.Command;
import model.World;
import worldevent.WorldEvent;
/**
 * 
 * Defines all the operation to update the model and pass model object 
 * to the view.
 */
public class GameLoopImpl implements GameLoop, Runnable {
    private final List<Command> movements = new ArrayList<>();
    private final List<Command> shoots = new ArrayList<>();
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
    public void run() {
        while (running) {
            final long now = System.nanoTime();
            final long sleepTime;
            final double delta = (now - this.lastLoop) / ((double) GameLoopImpl.SECONDNANO / 60); //Avanzo di tempo tra un frame e il successivo?
            
            update(delta);
            //Render
            checkEndGame();
            
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
        world.update(delta, this.movements, this.shoots);
    }
    //
    private void checkEndGame() {
        if (this.world.isGameOver()) {
            GameEngineImpl.get().gameOver();
        }
        if (this.world.isBossDefeated()) {
            GameEngineImpl.get().victory();
        }
    }
    /**
     * 
     */
    @Override
    public boolean isRunning() {
        return this.running;
    }
    //
    @Override
    public void notifyEvent(final WorldEvent we) {
        // TODO Auto-generated method stub
    }
    /**
     * 
     */
    @Override
    public void addShoot(final Command d) {
        shoots.add(d);
    }
    /**
     * 
     */
    @Override
    public void removeShoot(final Command d) {
        shoots.remove(d);
    }
    /**
     * 
     */
    @Override
    public void addMovement(final Command d) {
        movements.add(d);
    }
    /**
     * 
     */
    @Override
    public void removeMovement(final Command d) {
        movements.add(d);
    }
}
