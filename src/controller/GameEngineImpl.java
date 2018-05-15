package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import controller.util.Score;
import controller.util.ScoreImpl;
import model.World;
import model.WorldImpl;
import view.View;
import view.ViewImpl;
/**
 * GameEngineImpl manages all game situations.
 */
public final class GameEngineImpl implements GameEngine {
    static final int NAME = 0;
    static final int TIME = 1;
    static final int SCORE = 2;
    private static GameEngineImpl singleton;
    private World world;
    private GameLoop gameLoop;
    private final View gui;
    private List<Score> scoreList = new ArrayList<>();
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
    private void readLeaderboard() {
        File file = new File("");
        
        try {
            if (!file.createNewFile()) {
                BufferedReader in = new BufferedReader(new FileReader(file));
                for (String x = in.readLine(); x != null; x = in.readLine()) {
                    List<String> items = Arrays.asList(x.split(" "));
                    scoreList.add(new ScoreImpl(items.get(NAME), items.get(TIME), items.get(SCORE)));
                }
            }
        } catch (Exception e) {
            
        } finally {
            
        }
        
    }
}
