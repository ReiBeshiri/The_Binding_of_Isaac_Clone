package view;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.Event;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import view.controller.GameCanvasViewController;
import view.util.SceneFactory;

import static proxyutility.SceneType.GAME;

import controller.event.KeyEventImpl;
import controller.event.KeyType;

/**
 * Class that represent game scene.
 *
 */
public class GameScene extends AbstractGenericScene {

    private final InvalidationListener gameCanvasObserver;
    private final Canvas gameCanvas;

    /**
     * Constructor for game scene.
     */
    public GameScene() {
        super(GAME);
        gameCanvasObserver = new CanvasObserver();
        gameCanvas = ((GameCanvasViewController) super.getSceneController()).getGameCanvas();
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
            ViewImpl.get().notifyEvent(new KeyEventImpl(KeyCode.getKeyCode(e.getEventType().getName()),
                    this.getSceneType(), KeyType.KEY_PRESSED));
        } else if (e.getEventType().equals(KeyEvent.KEY_RELEASED)) {
            ViewImpl.get().notifyEvent(new KeyEventImpl(KeyCode.getKeyCode(e.getEventType().getName()),
                    this.getSceneType(), KeyType.KEY_RELEASED));
        }
    }

    /**
     * Add canvas listener.
     */
    public void addCanvasListener() {
        gameCanvas.heightProperty().bind(ViewManagerImpl.get().getMainStage().heightProperty());
        gameCanvas.widthProperty().bind(ViewManagerImpl.get().getMainStage().widthProperty());
        gameCanvas.heightProperty().addListener(gameCanvasObserver);
        gameCanvas.widthProperty().addListener(gameCanvasObserver);
    }
 
    /**
     * Remove canvas listener.
     */
    public void removeCanvasListener() {
        gameCanvas.heightProperty().unbind();
        gameCanvas.widthProperty().unbind();
        gameCanvas.heightProperty().removeListener(gameCanvasObserver);
        gameCanvas.widthProperty().removeListener(gameCanvasObserver);
    }

    private class CanvasObserver implements InvalidationListener {
        @Override
        public void invalidated(final Observable observable) {
            ViewManagerImpl.get().updateViewState();
        }
    }
}
