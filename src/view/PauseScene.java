package view;

import javafx.event.Event;
import static proxyutility.SceneType.PAUSE;

/**
 * Class for a pause scene.
 *
 */
public class PauseScene extends AbstractGenericScene {

    /**
     * Constructor for a pause scene.
     *
     */
    public PauseScene() {
        super(PAUSE);
    }

    /**
     * Exit status for a specific scene.
     */
    @Override
    public void exitStatus() {
        ViewManagerImpl.get().pop();
        //ViewImpl.get().notifyEvent(new ButtonEventImpl(ButtonType.RESUME_GAME, ""));
    }

    /**
     * Check events that occurs in this scene.
     */
    @Override
    public void checkSceneHandler(final Event e) { }

}
