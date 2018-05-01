package view;

import java.util.Objects;
import java.util.Stack;
import javafx.application.Application;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
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
        stage.setScene(stack.lastElement().getSceneController().getRoot().getScene());
        stage.getScene().addEventHandler(KeyEvent.ANY, stack.lastElement().getEventHandler());
    }

    /**
     * 
     */
    @Override
    public void pop() {
        if (stack.size() > 1) {
            stage.getScene().removeEventHandler(KeyEvent.ANY, stack.lastElement().getEventHandler());
            stack.pop();
            stage.setScene(stack.lastElement().getSceneController().getRoot().getScene());
        }
    }

    /**
     * 
     */
    @Override
    public void notifyEvent(final Event e) {
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
        primaryStage.show();
    }
}
