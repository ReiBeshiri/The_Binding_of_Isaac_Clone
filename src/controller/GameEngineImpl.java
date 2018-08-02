package controller;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import controller.observer.ButtonObserver;
import controller.observer.KeyObserver;
import controller.util.Score;
import controller.util.ScoreImpl;
import model.World;
import model.WorldImpl;
import model.animated.AbstractCharacter;
import timer.Time;
import utility.Mode;
import utility.ModelUtility;
import view.ViewImpl;
import view.util.ViewUtils;

/**
 * GameEngineImpl manages all game situations.
 */
public final class GameEngineImpl implements GameEngine {
    private static final int NAME = 0;
    private static final int SCORE = 1;
    private static final int TIME = 2;
    private static final int MINUTES = 0;
    private static final int SECONDS = 1;
    private static GameEngineImpl singleton;
    private GameLoop gameLoop;
    private List<Score> scoreList = new ArrayList<>();

    /**
     * The class constructor.
     */
    private GameEngineImpl() { }
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
        if (!Objects.isNull(scoreList)) {
            ViewImpl.get().setScoreBoard(scoreList);
        }
        //Passare alla view la leaderboard;
        ViewImpl.get().addObserver(new ButtonObserver());
        ViewImpl.get().addObserver(new KeyObserver());
        ViewImpl.get().setInitialHeight(
                ((int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()) / ViewUtils.getYScreenProp());
        ViewImpl.get().setInitialWidth(
                ((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()) / ViewUtils.getXScreenProp());
        ViewImpl.get().setWorldHeight(ModelUtility.getWorldHeight());
        ViewImpl.get().setWorldWidth(ModelUtility.getWorldWidth());
        ViewImpl.get().setWorldHeightProportion(ModelUtility.getWorldHeightProp());
        ViewImpl.get().setWorldWidthProportion(ModelUtility.getWorldWidthProp());
        ViewImpl.get().viewStart();
    }

    /**
     * Create a new game.
     * @param name of the player.
     */
    @Override
    public void newGame(final String name) {
        final World world = new WorldImpl();
        world.createEnvironment();
        if (ViewImpl.get().isGodModeSelected()) {
            world.setMode(Mode.GOD);
        } else if (ViewImpl.get().isInfinityModeSelected()) {
            world.setMode(Mode.INFINITE);
        } else {
            world.setMode(Mode.NORMAL);
        }
        //Dumb events created for start drawing life and time.
        ViewImpl.get().roomChanged(ModelUtility.getRoom());
        ViewImpl.get().playerLifeChanged(((AbstractCharacter) ModelUtility.getPlayer()).getLife());
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
        final File file = new File(System.getProperty("user.home") + File.separator + "Leaderboard.txt");
        List<String> items;
        List<String> splitTime;

        try {
            if (!file.createNewFile()) {
                final BufferedReader in = new BufferedReader(new FileReader(file));
                for (String x = in.readLine(); x != null; x = in.readLine()) {
                    items = Arrays.asList(x.split(" "));
                    splitTime = Arrays.asList(items.get(TIME).split(":"));
                    scoreList.add(new ScoreImpl(items.get(NAME), Integer.parseInt(items.get(SCORE)), 
                            new Time(Integer.parseInt(splitTime.get(MINUTES)), Integer.parseInt(splitTime.get(SECONDS)))));
                }
                in.close();
            }
        } catch (Exception e) {
            System.out.println("Error on reading leaderboard: " + e.getMessage()); //To change.
        }
    }
}
