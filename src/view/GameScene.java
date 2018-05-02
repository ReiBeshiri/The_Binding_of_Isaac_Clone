package view;

import javafx.event.Event;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import view.util.SceneFactory;

import static proxyutility.SceneType.GAME;

import controller.event.KeyEventImpl;
import controller.event.KeyType;

/**
 * Class that represent game scene.
 *
 */
public class GameScene extends AbstractGenericScene {
    /**
     * Constructor for game scene.
     */
    public GameScene() {
        super(GAME);
    }

    /**
     * Exit status of the scene.
     */
    @Override
    public void exitStatus() {
        ViewManagerImpl.get().push(SceneFactory.createPauseScene());
    }

    /**
     * Check specific handler of the scene.
     */
    @Override
    public void checkSceneHandler(final Event e) {
        if (e.getEventType().equals(KeyEvent.KEY_PRESSED)) {
            ViewManagerImpl.get().notifyEvent(new KeyEventImpl(KeyCode.getKeyCode(e.getEventType().getName()),
                    this.getSceneType(), KeyType.KEY_PRESSED));
        } else if (e.getEventType().equals(KeyEvent.KEY_RELEASED)) {
            ViewManagerImpl.get().notifyEvent(new KeyEventImpl(KeyCode.getKeyCode(e.getEventType().getName()),
                    this.getSceneType(), KeyType.KEY_RELEASED));
        }
    }

}
