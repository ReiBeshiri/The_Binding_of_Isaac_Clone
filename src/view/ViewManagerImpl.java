package view;

import java.util.Objects;
import java.util.Stack;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import proxyutility.SceneType;
import view.controller.GameCanvasViewController;
import view.util.SceneFactory;
import controller.event.Event;

/**
 * Class that represent view manager. 
 * This class is used to manage scene state.
 *
 */
public final class ViewManagerImpl extends Application implements ViewManager {
    private final Stack<GenericScene> stack;
    private Stage stage;
    private static ViewManager manager;
    private int heigth;
    private int width;
    private View view;

    private ViewManagerImpl() {
        super();
        stack = new Stack<>();
    }

    /**
     * Push scene Generic scene and update stack state.
     */
    @Override
    public void push(final GenericScene scene) {
        if (!stack.isEmpty()) {
            stage.getScene().removeEventHandler(KeyEvent.ANY, stack.lastElement().getEventHandler());
        }
        stack.push(scene);
        stage.setScene(new Scene(stack.lastElement().getSceneController().getRoot()));
        stage.getScene().addEventHandler(KeyEvent.ANY, stack.lastElement().getEventHandler());
        checkCurrentScene();
    }

    /**
     * 
     */
    @Override
    public void pop() {
        if (stack.size() > 1) {
            stage.getScene().removeEventHandler(KeyEvent.ANY, stack.lastElement().getEventHandler());
            final GenericScene removed = stack.pop();
            stage.setScene(new Scene(stack.lastElement().getSceneController().getRoot()));
            checkCurrentScene();
            checkRemovedScene(removed);
        }
    }

    /**
     * 
     */
    @Override
    public void notifyEvent(final Event e) {
        if (Objects.nonNull(view)) {
            view.notifyEvent(e);
        }
    }

    /**
     * Singleton for ViewManager.
     * @return Only instance of this class.
     */
    public static ViewManager get() {
        if (Objects.isNull(manager)) {
            manager = new ViewManagerImpl();
        }
        return manager;
    }

    /**
     * 
     */
    @Override
    public void setHeight(final int h) {
        heigth = h;
    }

    /**
     * 
     */
    @Override
    public void setWidth(final int w) {
        width = w;
    }

    /**
     * 
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setHeight(heigth);
        stage.setWidth(width);
        ViewManagerImpl.get().push(SceneFactory.createMenuScene());
        primaryStage.show();
    }

    /**
     * Set view instance.
     */
    @Override
    public void setViewReferene(final View v) {
        view = v;
    }

    /**
     * Get current scene.
     */
    @Override
    public GenericScene getCurrentScene() {
        return stack.lastElement();
    }

    /**
     * 
     */
    public void updateViewState() {

    }

    private void checkCurrentScene() {
        if (getCurrentScene().getSceneType() == SceneType.GAME) {
            final Canvas gameCanvas = ((GameCanvasViewController) getCurrentScene().getSceneController()).getGameCanvas();
            final GameScene gScene = (GameScene) getCurrentScene();
            gameCanvas.heightProperty().bind(stage.heightProperty());
            gameCanvas.widthProperty().bind(stage.widthProperty());
            gameCanvas.heightProperty().addListener(gScene.getCanvasObserver());
            gameCanvas.widthProperty().addListener(gScene.getCanvasObserver());
        }
    }

    private void checkRemovedScene(final GenericScene removed) {
        if (getCurrentScene().getSceneType() == SceneType.GAME) {
            final Canvas gameCanvas = ((GameCanvasViewController) getCurrentScene().getSceneController()).getGameCanvas();
            final GameScene gScene = (GameScene) getCurrentScene();
            gameCanvas.heightProperty().unbind();
            gameCanvas.widthProperty().unbind();
            gameCanvas.heightProperty().removeListener(gScene.getCanvasObserver());
            gameCanvas.widthProperty().removeListener(gScene.getCanvasObserver());
        }
    }
}
