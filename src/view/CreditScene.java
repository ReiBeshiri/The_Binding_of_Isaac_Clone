package view;

import javafx.event.Event;
import view.util.SceneFactory;

import static proxyutility.SceneType.CREDITS;
/**
 * Class that represent Credit scene.
 *
 */
public class CreditScene extends AbstractGenericScene {
    /**
     * Constructor for credit scene.
     */
    public CreditScene() {
        super(CREDITS);
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
