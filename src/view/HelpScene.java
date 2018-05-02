package view;

import javafx.event.Event;
import view.util.SceneFactory;

import static proxyutility.SceneType.HELP;
/**
 * Class that represent help game scene.
 *
 */
public class HelpScene extends AbstractGenericScene {
    /**
     * Constructor for a help scene.
     */
    public HelpScene() {
        super(HELP);
    }

    /**
     * Exit status for the specific scene.
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
