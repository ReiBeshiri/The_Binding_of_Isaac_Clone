package view;

import java.util.Objects;
import java.util.Stack;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import proxyutility.SceneType;
import view.util.SceneFactory;

/**
 * Class that represent view manager. This class is used to manage scene state.
 *
 */
public final class ViewManagerImpl extends Application implements ViewManager {
    private final Stack<GenericScene> stack;
    private Stage stage;
    private static ViewManager manager;
    private double heigth;
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
        stage.setScene(new Scene(stack.lastElement().getSceneController().getRoot()));
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
            stage.setScene(new Scene(stack.lastElement().getSceneController().getRoot()));
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
     * 
     */
    @Override
    public void setHeight(final double h) {
        heigth = h;
    }

    /**
     * 
     */
    @Override
    public void setWidth(final double w) {
        width = w;
    }

    /**
     * Entry method of javaFX.
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        stage = primaryStage;
        stage.setHeight(heigth);
        stage.setWidth(width);
        ViewManagerImpl.get().push(SceneFactory.createMenuScene());
        primaryStage.widthProperty().addListener(o -> updateViewState());
        primaryStage.heightProperty().addListener(o -> updateViewState());
        primaryStage.show();
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
     * 
     */
    @Override
    public double getStageHeight() {
        return stage.getHeight();
    }

    /**
     * 
     */
    @Override
    public double getStageWidth() {
        return stage.getWidth();
    }

}
