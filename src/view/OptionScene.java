package view;

import javafx.event.Event;
import static proxyutility.SceneType.OPTIONS;
/**
 * Class that represent option scene.
 *
 */
public class OptionScene extends AbstractGenericScene {
    /**
     * Constructor fir a option scene.
     */
    public OptionScene() {
        super(OPTIONS);
    }
    /**
     * Exit status for this specific scene.
     */
    @Override
    public void exitStatus() {
        //Use state factory,
        ViewManagerImpl.get().push(null);
    }

    /**
     * 
     */
    @Override
    public void checkSceneHandler(final Event e) { }

}
