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
import timer.Time;
import view.View;
import view.ViewImpl;
/**
 * GameEngineImpl manages all game situations.
 */
public final class GameEngineImpl implements GameEngine {
    static final int NAME = 0;
    static final int SCORE = 1;
    static final int TIME = 2;
    static final int MINUTES = 0;
    static final int SECONDS = 1;
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
        readLeaderboard();
        //Passare alla view la leaderboard;
        gui.viewStart();
    }
    /**
     * Create a new game.
     * @param name of the player.
     */
    @Override
    public void newGame(final String name) {
        this.world = new WorldImpl();
        this.gameLoop = new GameLoopImpl(world, name);
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
     * Get the leaderboard of this computer.
     * @return the leaderboard.
     */
    public List<Score> getLeaderboard() {
        return this.scoreList;
    }
    /**
     * Set the leaderboard.
     */
    @Override
    public void setLeaderboard(final List<Score> list) {
        this.scoreList = list;
        //Qui bisogna fare il savataggio.
    }
    /**
     * Read the saves.
     */
    private void readLeaderboard() {
        File file = new File("C:\\Users\\andre\\Desktop\\LeaderBoard.txt");
        List<String> items;
        List<String> splitTime;

        try {
            if (!file.createNewFile()) {
                BufferedReader in = new BufferedReader(new FileReader(file));
                for (String x = in.readLine(); x != null; x = in.readLine()) {
                    items = Arrays.asList(x.split(" "));
                    splitTime = Arrays.asList(items.get(TIME).split(":"));
                    scoreList.add(new ScoreImpl(items.get(NAME), Integer.parseInt(items.get(SCORE)), 
                            new Time(Integer.parseInt(splitTime.get(MINUTES)), Integer.parseInt(splitTime.get(SECONDS)))));
                }
                in.close();
            }
        } catch (Exception e) {
            e.getMessage(); //To change.
        }
    }
}
