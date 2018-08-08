package view;

import static view.utility.SceneType.CREDITS;
import javafx.event.Event;

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
        ViewManagerImpl.get().pop();
        //ViewManagerImpl.get().push(SceneFactory.createMenuScene());
    }
    /**
     * 
     */
    @Override
    public void checkSceneHandler(final Event e) { }

    /**
     * Set scene listener.
     */
    @Override
    public void setSceneListener() { }

    /**
     * Remove scene listener.
     */
    @Override
    public void removeSceneListener() { }
}
