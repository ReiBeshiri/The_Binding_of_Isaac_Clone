package view;

import static view.utility.SceneType.WIN;

import javafx.event.Event;

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

    /**
     * Exit status for this scene.
     */
    @Override
    public void exitStatus() { }

    /**
     * Check event handler for this scene.
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
