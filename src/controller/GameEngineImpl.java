package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashSet;
import java.util.Set;

import input.Command;
import worldevent.WorldEvent;

/**
 * 
 * s.
 *
 */
public class GameEngineImpl implements GameEngine {
    private final Set<Command> movements = new HashSet<>();
    private final Set<Command> shoots = new HashSet<>();
    @Override
    public void initGame() {
    }

    @Override
    public void mainLoop() {
        // TODO Auto-generated method stub

    }

    @Override
    public void getActualTime() {
        // TODO Auto-generated method stub

    }

    @Override
    public void stopGameLoop() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resumeGameLoop() {
        // TODO Auto-generated method stub

    }

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
