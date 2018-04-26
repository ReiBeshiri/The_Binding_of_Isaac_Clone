package controller;

import java.util.Objects;
import model.World;
import model.WorldImpl;
import view.View;
import view.ViewImpl;
/**
 * 
 * s.
 *
 */
public class GameEngineImpl implements GameEngine {
    private static GameEngineImpl singleton;
    private World world;
    private GameLoop gameLoop;
    private final View gui;
    /**
     * 
     */
    public GameEngineImpl() {
        gui = new ViewImpl(); //gui = ViewImpl.get();
    }
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
    /**
     * 
     */
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
    /**
     * 
     */
    @Override
    public void stopGameLoop() {
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
    /**
     * 
     */
    @Override
    public void gameOver() {
        //gui.gameOver();
        stopGameLoop();
    }
    /**
     * 
     */
    public void victory() {
        //gui.victory();
        stopGameLoop();
    }
    /**
     * @return the gameLoop;
     */
    public GameLoop getGameLoop() {
        return this.gameLoop;
    }
}
