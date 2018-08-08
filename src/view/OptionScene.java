package view;

import static view.utility.SceneType.OPTIONS;

import javafx.event.Event;

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
        ViewManagerImpl.get().pop();
    }

    /**
     * 
     */
    @Override
    public void checkSceneHandler(final Event e) { }

    /**
     * Used when focus up.
     */
    @Override
    public void notifyFocusUp() { }

    /**
     * Used when focus down.
     */
    @Override
    public void notifyFocusDown() { }
}
