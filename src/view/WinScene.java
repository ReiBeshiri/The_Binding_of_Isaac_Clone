package view;

import javafx.event.Event;
import static proxyutility.SceneType.WIN;

/**
 * Class that represent win scene.
 *
 */
public class WinScene extends AbstractGenericScene {

    /**
     * Constructor for this class.
     */
    public WinScene() {
        super(WIN);
    }

    @Override
    public void exitStatus() { }

    @Override
    public void checkSceneHandler(final Event e) { }

}
