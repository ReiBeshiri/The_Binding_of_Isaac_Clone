package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import input.Command;
import model.World;
import model.WorldImpl;
import worldevent.WorldEvent;

/**
 * 
 * s.
 *
 */
public class GameEngineImpl implements GameEngine {
    private final Set<Command> movements = new HashSet<>();
    private final Set<Command> shoots = new HashSet<>();
    private static GameEngineImpl singleton;
    private World world;
    private GameLoop gameLoop;
    /**
     * Get the instance of GameEngineImpl.
     * @return the instance of controller.
     */
    public static GameEngine get() {
        if (Objects.isNull(singleton)) {
            singleton = new GameEngineImpl();
        }
        return singleton;
    }
    @Override
    public void initView() {
    }
    /**
     * 
     */
    @Override
    public void newGame() {
        this.world = new WorldImpl();
        this.gameLoop = new GameLoopImpl(world);
        resumeGameLoop();
    }

    @Override
    public void getActualTime() {
        // TODO Auto-generated method stub

    }
    /**
     * 
     */
    @Override
    public void stopGameLoop() {
        cleanKeys();
        gameLoop.stop();
    }
    /**
     * 
     */
    @Override
    public void resumeGameLoop() {
        if (!Objects.isNull(gameLoop)) {
            gameLoop.start();
        }
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
    /**
     * 
     */
    @Override
    public Set<Command> getKeyShootListener() {
        return this.shoots;
    }
    /**
     * 
     */
    @Override
    public Set<Command> getKeyMovementList() {
        return this.shoots;
    }
    /**
     * 
     */
    @Override
    public void gameOver() {
        //gui.gameOver();
        stopGameLoop();
    }
    private void cleanKeys() {
        this.movements.clear();
        this.shoots.clear();
    }

}
