package view;

import javafx.event.Event;
import javafx.scene.input.KeyEvent;
import controller.event.KeyEventImpl;
import controller.event.KeyType;
import static proxyutility.SceneType.PAUSE;

/**
 * Class for a pause scene.
 *
 */
public class PauseScene extends AbstractGenericScene {

    /**
     * Constructor for a pause scene.
     *
     */
    public PauseScene() {
        super(PAUSE);
    }

    /**
     * Exit status for a specific scene.
     */
    @Override
    public void exitStatus() {
        ViewManagerImpl.get().pop();
        //ViewImpl.get().notifyEvent(new ButtonEventImpl(ButtonType.RESUME_GAME, ""));
    }

    /**
     * Check events that occurs in this scene.
     */
    @Override
    public void checkSceneHandler(final Event e) { 
        if (e.getEventType().equals(KeyEvent.KEY_PRESSED)) {
            ViewImpl.get().notifyEvent(new KeyEventImpl(((KeyEvent) e).getCode(),
                    this.getSceneType(), KeyType.KEY_PRESSED));
        }
    }

}
