package view;

import javafx.event.Event;
import static proxyutility.SceneType.NEWGAME;
/**
 * New game scene.
 * 
 */
public class NewGameScene extends AbstractGenericScene {
    /**
     * Constructor for a new game scene.
     * 
     */
    public NewGameScene() {
        super(NEWGAME);
    }

    @Override
    public void exitStatus() { }

    @Override
    public void checkSceneHandler(final Event e) { }

}
