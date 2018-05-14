package controller;

import java.io.File;
import java.util.Objects;
import model.World;
import model.WorldImpl;
import view.View;
import view.ViewImpl;
/**
 * GameEngineImpl manages all game situations.
 */
public final class GameEngineImpl implements GameEngine {
    private static GameEngineImpl singleton;
    private World world;
    private GameLoop gameLoop;
    private final View gui;
    /**
     * The class constructor.
     */
    private GameEngineImpl() {
        gui = new ViewImpl();
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
     * Initialize the view for the kts application.
     */
    @Override
    public void initView() {
        readSaves();
        gui.viewStart();
    }
    /**
     * Create a new game.
     */
    @Override
    public void newGame() {
        this.world = new WorldImpl();
        this.gameLoop = new GameLoopImpl(world);
        resumeGameLoop();
    }
    /**
     * Stop the game.
     */
    @Override
    public void stopGame() {
        gameLoop.stop();
    }
    /**
     * Resume the execution of the game.
     */
    @Override
    public void resumeGameLoop() {
        if (!Objects.isNull(gameLoop)) {
            gameLoop.start();
        }
    }
    /**
     * The player has lost.
     */
    @Override
    public void gameOver() {
        //gui.gameOver();
        stopGame();
    }
    /**
     * The player has won.
     */
    public void victory() {
        //gui.victory();
        stopGame();
    }
    /**
     * @return the gameLoop object. 
     */
    public GameLoop getGameLoop() {
        return this.gameLoop;
    }
    /**
     * Read the saves.
     */
    private void readSaves() {
        File file = new File("");
        try {
            if (file.exists()) {
            } else {
                file.createNewFile();
            }
        }
            
        }
        
    }
}
