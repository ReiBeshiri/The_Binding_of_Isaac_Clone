package view;

import java.util.Objects;
import java.util.Stack;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import proxyutility.SceneType;

/**
 * Class that represent view manager. This class is used to manage scene state.
 *
 */
public final class ViewManagerImpl implements ViewManager {
    private final Stack<GenericScene> stack;
    private Stage stage;
    private static ViewManager manager;
    private double height;
    private double width;

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
        stage.setScene(new Scene(stack.lastElement().getSceneController().getRoot(), Color.DARKGRAY));
        stage.getScene().addEventHandler(KeyEvent.ANY, stack.lastElement().getEventHandler());
    }

    /**
     * Pop scene.
     */
    @Override
    public void pop() {
        if (stack.size() > 1) {
            stage.getScene().removeEventHandler(KeyEvent.ANY, stack.lastElement().getEventHandler());
            stack.pop();
            stage.setScene(new Scene(stack.lastElement().getSceneController().getRoot(), Color.DARKGRAY));
            stage.getScene().addEventHandler(KeyEvent.ANY, stack.lastElement().getEventHandler());
        }
    }

    /**
     * Singleton for ViewManager.
     * 
     * @return Only instance of this class.
     */
    public static ViewManager get() {
        if (Objects.isNull(manager)) {
            manager = new ViewManagerImpl();
        }
        return manager;
    }

    /**
     * Set initial height of stage.
     */
    @Override
    public void setHeight(final double h) {
        height = h;
    }

    /**
     * Set initial width of stage.
     */
    @Override
    public void setWidth(final double w) {
        width = w;
    }

    /**
     * Get current scene.
     */
    @Override
    public GenericScene getCurrentScene() {
        return stack.lastElement();
    }

    /**
     * Update view state when stage dimension changed.
     */
    public void updateViewState() {
        if (getCurrentScene().getSceneType() == SceneType.GAME) {
            ViewImpl.get().redraw();
        }
    }

    /**
     * Get actual height of stage.
     */
    @Override
    public double getStageHeight() {
        return stage.getHeight();
    }

    /**
     * Get actual width of stage.
     */
    @Override
    public double getStageWidth() {
        return stage.getWidth();
    }

    /**
     * Set stage.
     */
    @Override
    public void setMainStage(final Stage primaryStage) {
        stage = primaryStage;
    }

    /**
     * Get height.
     */
    @Override
    public double getStartedHeight() {
        return height;
    }

    /**
     * Get width.
     */
    @Override
    public double getStartedWidth() {
        return width;
    }

}
