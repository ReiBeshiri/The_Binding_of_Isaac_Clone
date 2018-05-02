package view.util;

import view.CreditScene;
import view.EndGameScene;
import view.GameScene;
import view.GenericScene;
import view.HelpScene;
import view.MainMenuScene;
import view.OptionScene;
import view.PauseScene;
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
     * create new end game scene.
     * @return end game scene.
     */
    public static GenericScene createEndGameScene() {
        return new EndGameScene();
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

}
