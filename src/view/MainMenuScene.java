package view;

import javafx.event.Event;
import static proxyutility.SceneType.MENU;
/**
 * Class that represent menu scene.
 *
 */
public class MainMenuScene extends AbstractGenericScene {

    /**
     * Constructor for menu scene.
     */
    public MainMenuScene() {
        super(MENU);
    }

    /**
     * Exit status for the specific scene.
     */
    @Override
    public void exitStatus() { }

    /**
     * 
     */
    @Override
    public void checkSceneHandler(final Event e) { }

}
