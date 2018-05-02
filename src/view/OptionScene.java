package view;

import javafx.event.Event;
import view.util.SceneFactory;

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
        ViewManagerImpl.get().push(SceneFactory.createMenuScene());
    }

    /**
     * 
     */
    @Override
    public void checkSceneHandler(final Event e) { }

}
