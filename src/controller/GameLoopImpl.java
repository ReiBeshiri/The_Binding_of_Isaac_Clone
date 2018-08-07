package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import controller.util.LeaderboardComparator;
import controller.util.Score;
import controller.util.ScoreCalculator;
import controller.util.ScoreImpl;
import input.Command;
import model.World;
import timer.Time;
import timer.TimeAgent;
import utility.ModelUtility;
import view.ViewImpl;
import worldevent.BossFightStarted;
import worldevent.PlayerDied;
import worldevent.PlayerHeartChange;
import worldevent.PlayerHitButton;
import worldevent.PlayerKillAllEnemy;
import worldevent.PlayerKillBoss;
import worldevent.PlayerKillEnemy;
import worldevent.PlayerScoreChange;
import worldevent.RoomChange;
import worldevent.WorldEvent;

/**
 * 
 * Defines all the operation for update the model and pass the information of model 
 * to the view for update the graphic.
 */
public class GameLoopImpl implements GameLoop, Runnable {
    private final List<Command> movement = new ArrayList<>();
    private final List<Command> shot = new ArrayList<>();
    private static final long SECONDMICRO = 1000000;
    private static final int SECONDNANO = 1000000000;
    private static final int FPS = 60;
    private boolean running;
    private Thread gameLoopThread; 
    private int optimalTime;
    private long lastLoop;
    private final World world;
    private int point;
    private Thread timerThread;
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
            gameLoopThread = new Thread(this);
            gameLoopThread.setDaemon(true);
            gameLoopThread.start();
            if (ModelUtility.pauseDuringRound()) {
                startTime();
            }
        }
    }

    /**
     * Stop the game loop.
     */
    @Override
    public void stop() {
        if (running) {
            interrupt();
            if (!Objects.isNull(timerThread) && timeAgent.isRunning()) {
                stopTime();
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
            lastLoop = now;

            update(delta);
            ViewImpl.get().render(ModelUtility.getAnimatedObjects());
            checkEvent();

            sleepTime = (lastLoop - System.nanoTime() + optimalTime) / GameLoopImpl.SECONDMICRO;
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (Exception e) {
                    System.out.println("Sleep timer method on run errror: " + e.getMessage());
                }
            }
        }
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
        if (!movement.contains(d)) {
            movement.add(d);
        }
    }

    /**
     * Remove a movement from the list.
     */
    @Override
    public void removeMovement(final Command d) {
        movement.remove(d);
    }

    /**
     * Get player's name.
     * @return the player's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Interrupt event, that stop thread.
     */
    private void interrupt() {
        running = false;
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
        final List<WorldEvent> worldEvent = Objects.isNull(ModelUtility.getWorldEventList()) ? Collections.emptyList()
                : ModelUtility.getWorldEventList();
        worldEvent.forEach(x -> {
            if (x instanceof PlayerHitButton && (Objects.isNull(timerThread) || !timerThread.isAlive())) {
                startTime();
            } else if (x instanceof PlayerKillEnemy) {
                point += ((PlayerKillEnemy) x).getPoint();
            } else if (x instanceof PlayerScoreChange) {
                point -= ((PlayerScoreChange) x).getPoints();
            } else if (x instanceof PlayerKillAllEnemy) {
                stopTime();
            } else if (x instanceof BossFightStarted) {
                startTime();
            } else if (x instanceof PlayerKillBoss) {
                stopTime();
                point += bonusTime(time.getTimeInSeconds()); // BONUS TIME ONLY IF BOSS DIED.
                checkResultWithLeaderboard();
                GameEngineImpl.get().victory(point);
            } else if (x instanceof PlayerDied) {
                stopTime();
                checkResultWithLeaderboard();
                GameEngineImpl.get().gameOver(point);
            } else if (x instanceof PlayerHeartChange) {
                ViewImpl.get().playerLifeChanged(((PlayerHeartChange) x).getCurretLife());
            } else if (x instanceof RoomChange) {
                ViewImpl.get().roomChanged(((RoomChange) x).getNewRoom());
            }
        });
    }

    /**
     * 
     * @param timeElapsed The time the player took to finish the game.
     * @return Bonus point based on time.
     */
    private int bonusTime(final int timeElapsed) {
        return ScoreCalculator.bonusTime(timeElapsed);
    }

    /**
     * Start the time.
     */
    private void startTime() {
        timeAgent = new TimeAgent(time);
        if (!time.getListeners().contains(ViewImpl.get().getDrawerReference())) {
            time.addListener(ViewImpl.get().getDrawerReference());
        }
        timerThread = new Thread(timeAgent);
        timerThread.setDaemon(true);
        timerThread.start();
    }

    /**
     * Stop the time.
     */
    private void stopTime() {
        timeAgent.interrupt();
    }

    /**
     * Method used to check result with leaderboard results.
     */
    private void checkResultWithLeaderboard() {
        final Score score = new ScoreImpl(name, point, time);
        final List<Score> leaderboard = GameEngineImpl.get().getLeaderboard();
        if (leaderboard.size() < 10) {
            leaderboard.add(score);
            leaderboard.sort(new LeaderboardComparator<>());
            GameEngineImpl.get().setLeaderboard(leaderboard);
        } else if (score.compareTo(leaderboard.get(leaderboard.size() - 1)) > 0) {
            leaderboard.remove(leaderboard.size() - 1);
            leaderboard.add(score);
            leaderboard.sort(new LeaderboardComparator<Score>());
            GameEngineImpl.get().setLeaderboard(leaderboard);
        }
    }
}
