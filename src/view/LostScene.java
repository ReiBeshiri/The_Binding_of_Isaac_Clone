package view;

import static view.utility.SceneType.LOST;

import javafx.event.Event;

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
