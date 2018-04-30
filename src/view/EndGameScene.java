package view;

import javafx.application.Platform;
import javafx.event.Event;
import static proxyutility.SceneType.ENDGAME;
/**
 * Class that represent end game scene.
 *
 */
public class EndGameScene extends AbstractGenericScene {
    /**
     * Constructor for end game scene.
     */
    public EndGameScene() {
        super(ENDGAME);
    }
    /**
     * Close window.
     */
    @Override
    public void exitStatus() {
        //Send shoutdown signal.
        Platform.runLater(() -> System.exit(0));
    }
    /**
     * 
     */
    @Override
    public void checkSceneHandler(final Event e) { }

}
