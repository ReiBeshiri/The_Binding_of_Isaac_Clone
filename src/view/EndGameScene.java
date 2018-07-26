package view;

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
    public void exitStatus() { }

    /**
     * 
     */
    @Override
    public void checkSceneHandler(final Event e) { }

}
