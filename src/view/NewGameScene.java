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

    /**
     * Exit status for this scene.
     */
    @Override
    public void exitStatus() {
        ViewManagerImpl.get().pop();
    }

    @Override
    public void checkSceneHandler(final Event e) { }

}
