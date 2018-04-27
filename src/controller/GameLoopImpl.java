package controller;

import java.util.ArrayList;
import java.util.List;
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
 * Defines all the operation to update the model and pass model object 
 * to the view.
 */
public class GameLoopImpl implements GameLoop, Runnable {
    private final List<Command> movements = new ArrayList<>();
    private final List<Command> shoots = new ArrayList<>();
    private List<WorldEvent> worldEvent = new ArrayList<>();
    private static final long SECONDMICRO = 1000000;
    private static final int SECONDNANO = 1000000000;
    private static final int FPS = 60;
    private static final int MSWAIT = 5;
    private static final int MAX_TIME_BONUS = 180;
    private boolean running;
    private Thread thread; 
    private int optimalTime; //A cosa serve?
    private long lastLoop;
    private World world;
    private int score;
    private TimeAgent timeAgent;
    private final Time time;
    /**
     * 
     * @param world The instance of the model
     */
    public GameLoopImpl(final World world) {
        this.world = world;
        time = new Time(0, 0);
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
            thread = new Thread(this);
            thread.start();
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
     * 
     * @param delta
     */
    private void update(final double delta) {
        world.update(delta, this.movements, this.shoots);
    }
    //
    private void checkEvent() {
        this.worldEvent = utility.ModelUtility.getWorldEventList();
        worldEvent.forEach(x -> {
            if (x instanceof PlayerHitButton) {
                startTime();
            } else if (x instanceof PlayerKillEnemy) {
                score += ((PlayerKillEnemy) x).getPoint();
            } else if (x instanceof PlayerKillAllEnemy) {
                stopTime();
            } else if (x instanceof BossFightStarted) {
                startTime();
            } else if (x instanceof PlayerKillBoss) {
                stopTime();
                score += bonusTime(time.getTimeInSeconds());
                GameEngineImpl.get().victory();
            } else if (x instanceof PlayerDied) {
                stopTime();
                GameEngineImpl.get().gameOver();
            }
        });
    }
    //
    private int bonusTime(final int timeElapsed) {
        return (GameLoopImpl.MAX_TIME_BONUS - timeElapsed);
    }
    //
    private void startTime() {
        timeAgent = new TimeAgent(time);
        timeAgent.start();
    }
    private void stopTime() {
        timeAgent.interrupt();
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
