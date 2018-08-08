package view;

import static view.utility.SceneType.HELP;

import javafx.event.Event;
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
        ViewManagerImpl.get().pop();
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
