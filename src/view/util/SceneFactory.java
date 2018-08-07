package view.util;

import view.CreditScene;
import view.GameScene;
import view.GenericScene;
import view.HelpScene;
import view.LeaderboardScene;
import view.LostScene;
import view.MainMenuScene;
import view.NewGameScene;
import view.OptionScene;
import view.PauseScene;
import view.WinScene;
/**
 * Class that represent scene factory.
 *
 */
public final class SceneFactory {

    private SceneFactory() { }

    /**
     * create new credit scene.
     * @return credit scene.
     */
    public static GenericScene createCreditScene() {
        return new CreditScene();
    }

    /**
     * create new game scene.
     * @return game scene.
     */
    public static GenericScene createGameScene() {
        return new GameScene();
    }

    /**
     * create new help scene.
     * @return help scene.
     */
    public static GenericScene createHelpScene() {
        return new HelpScene();
    }

    /**
     * create new menu scene.
     * @return menu scene.
     */
    public static GenericScene createMenuScene() {
        return new MainMenuScene();
    }

    /**
     * create new option scene.
     * @return option scene.
     */
    public static GenericScene createOptionScene() {
        return new OptionScene();
    }

    /**
     * create new pause scene.
     * @return pause scene.
     */
    public static GenericScene createPauseScene() {
        return new PauseScene();
    }

    /**
     * create leaderboard scene.
     * @return leaderboard scene.
     */
    public static GenericScene createLeaderboardScene() {
        return new LeaderboardScene();
    }

    /**
     * create new game scene.
     * @return new game scene.
     */
    public static GenericScene createNewGameScene() {
        return new NewGameScene();
    }

    /**
     * create victory scene.
     * @return new class that represent victory scene.
     */
    public static GenericScene createVictoryScene() {
        return new WinScene();
    }

    /**
     * create lost scene.
     * @return new class that represent lost scene.
     */
    public static GenericScene createLostScene() {
        return new LostScene();
    }
}
