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
        //Use scene factory.
        ViewManagerImpl.get().push(null);
    }

    @Override
    public void checkSceneHandler(final Event e) { }

}
