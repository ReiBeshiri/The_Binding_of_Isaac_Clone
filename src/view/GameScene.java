package view;

import javafx.beans.InvalidationListener;
import javafx.event.Event;
import javafx.scene.input.KeyEvent;
import view.util.SceneFactory;
import controller.event.KeyEventImpl;
import controller.event.KeyType;
import static proxyutility.SceneType.GAME;

/**
 * Class that represent game scene.
 *
 */
public class GameScene extends AbstractGenericScene {

    private static final InvalidationListener LISTENER = x -> ViewImpl.get().redraw();
    /**
     * Constructor for game scene.
     */
    public GameScene() {
        super(GAME);
        ViewManagerImpl.get().getStage().heightProperty().addListener(LISTENER);
        ViewManagerImpl.get().getStage().widthProperty().addListener(LISTENER);
    }

    /**
     * Exit status of the scene.
     */
    @Override
    public void exitStatus() {
        ViewManagerImpl.get().push(SceneFactory.createPauseScene());
        ViewManagerImpl.get().getStage().heightProperty().removeListener(LISTENER);
        ViewManagerImpl.get().getStage().widthProperty().removeListener(LISTENER);
    }

    /**
     * Check specific handler of the scene.
     */
    @Override
    public void checkSceneHandler(final Event e) {
        if (e.getEventType().equals(KeyEvent.KEY_PRESSED)) {
            ViewImpl.get().notifyEvent(new KeyEventImpl(((KeyEvent) e).getCode(),
                    this.getSceneType(), KeyType.KEY_PRESSED));
        } else if (e.getEventType().equals(KeyEvent.KEY_RELEASED)) {
            ViewImpl.get().notifyEvent(new KeyEventImpl(((KeyEvent) e).getCode(),
                    this.getSceneType(), KeyType.KEY_RELEASED));
        }
    }

}
