package view;

import javafx.event.Event;
import static proxyutility.SceneType.LOST;

/**
 * Class that represent lost scene.
 *
 */
public class LostScene extends AbstractGenericScene {

    /**
     * Constructor for this class.
     */
    public LostScene() {
        super(LOST);
    }

    @Override
    public void exitStatus() { }

    @Override
    public void checkSceneHandler(final Event e) { }

}
