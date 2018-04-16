package controller;

import java.util.Set;
import input.Command;

/**
 *     Note: when the GameLoopImpl class will be added this class should implement Runnable
 *      and not extends Thread so it can extends some other utility class.
 */
public interface GameLoop {
    /**
     * Start the game loop.
     */
    void start();
    /**
     * Stop the game loop.
     */
    void stop();
    /**
     * 
     * @return true if the game loop is running, false otherwise.
     */
    boolean isRunning();
    /**
     * 
     * @param delta s.
     * @param shoots s.
     * @param movements s.
     */
    void update(double delta, Set<Command> shoots, Set<Command> movements);
}
