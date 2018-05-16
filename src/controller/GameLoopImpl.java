

package controller;

import java.util.ArrayList;
import java.util.List;

import controller.util.Score;
import controller.util.ScoreImpl;
import input.Command;
import model.World;
import timer.Time;
import timer.TimeAgent;
import worldevent.BossFightStarted;
import worldevent.PlayerDied;
import worldevent.PlayerHitButton;
import worldevent.PlayerKillAllEnemy;
import worldevent.PlayerKillBoss;
import worldevent.PlayerKillEnemy;
import worldevent.WorldEvent;
/**
 * 
 * Defines all the operation for update the model and pass the information of model 
 * to the view for update the graphic.
 */
public class GameLoopImpl implements GameLoop, Runnable {
    private final List<Command> movement = new ArrayList<>();
    private final List<Command> shot = new ArrayList<>();
    private List<WorldEvent> worldEvent = new ArrayList<>();
    private static final long SECONDMICRO = 1000000;
    private static final int SECONDNANO = 1000000000;
    private static final int FPS = 60;
    private static final int MSWAIT = 5;
    private boolean running;
    private Thread thread; 
    private int optimalTime; //A cosa serve?
    private long lastLoop;
    private World world;
    private int point;
    private TimeAgent timeAgent;
    private final Time time;
    private final String name;
    /**
     * The class constructor.
     * @param world The instance of the model
     * @param name of the player.s
     */
    public GameLoopImpl(final World world, final String name) {
        this.world = world;
        this.name = name;
        time = new Time(0, 0);
    }
    /**
     * Start the game loop.
     */
    @Override
    public void start() {
        if (!running) {
            this.running = true;
            optimalTime = GameLoopImpl.SECONDNANO / GameLoopImpl.FPS;
            this.lastLoop = System.nanoTime();
            thread = new Thread(this);
            thread.start();
        }
    }
    /**
     * Stop the game loop.
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
     * Method that implement the game loop of the game. It updates world, manage the world events and call the render.
     */
    @Override
    public void run() {
        while (running) {
            final long now = System.nanoTime();
            final long sleepTime;
            final double delta = (now - this.lastLoop) / ((double) GameLoopImpl.SECONDNANO / 60);

            update(delta);
            //Render
            checkEvent();

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
     * Call the the world's method update(). 
     * @param delta The time between a frame and the next.
     */
    private void update(final double delta) {
        world.update(delta, this.movement, this.shot);
    }
    /**
     * Check the world's events.
     */
    private void checkEvent() {
        this.worldEvent = utility.ModelUtility.getWorldEventList();
        worldEvent.forEach(x -> {
            if (x instanceof PlayerHitButton) {
                startTime();
            } else if (x instanceof PlayerKillEnemy) {
                point += ((PlayerKillEnemy) x).getPoint();
            } else if (x instanceof PlayerKillAllEnemy) {
                stopTime();
            } else if (x instanceof BossFightStarted) {
                startTime();
            } else if (x instanceof PlayerKillBoss) {
                stopTime();
                point += bonusTime(time.getTimeInSeconds());
                Score score = new ScoreImpl(name, point, time);
                GameEngineImpl.get().victory();
            } else if (x instanceof PlayerDied) {
                stopTime();
                GameEngineImpl.get().gameOver();
            }
        });
    }
    /**
     * 
     * @param timeElapsed The time the player took to finish the game.
     * @return Bonus point based on time.
     */
    private int bonusTime(final int timeElapsed) {
        return 1000 * (int) Math.exp(-(Math.pow(timeElapsed, 2)) / 200000); //Bisogna guardarci meglio;
    }
    /**
     * Start the time.
     */
    private void startTime() {
        timeAgent = new TimeAgent(time);
        timeAgent.start();
    }
    /**
     * Stop the time.
     */
    private void stopTime() {
        timeAgent.interrupt();
    }
    /**
     * Return true if the game loop is running, false otherwise.
     */
    @Override
    public boolean isRunning() {
        return this.running;
    }
    /**
     * Add a shot to list.
     */
    @Override
    public void addShot(final Command d) {
        shot.add(d);
    }
    /**
     * Remove a shot from the list.
     */
    @Override
    public void removeShot(final Command d) {
        shot.remove(d);
    }
    /**
     * Add a movement to list.
     */
    @Override
    public void addMovement(final Command d) {
        movement.add(d);
    }
    /**
     * Remove a movement from the list.
     */
    @Override
    public void removeMovement(final Command d) {
        movement.add(d);
    }
    /**
     * Get player's name.
     * @return the player's name.
     */
    public String getName() {
        return this.name;
    }
}
