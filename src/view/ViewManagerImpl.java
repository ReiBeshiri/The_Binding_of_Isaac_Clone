package view;

import java.util.Objects;
import java.util.Stack;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
/**
 * 
 *
 */
public final class ViewManagerImpl extends Application implements ViewManager {
    private final Stack<GenericScene> stack;
    private Stage stage;
    private ViewManager manager;
    private ViewManagerImpl() {
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
    }
    /**
     * 
     */
    @Override
    public void pop() {
        if (stack.size() > 1) {
            stage.getScene()
        }
    }
    /**
     * 
     */
    @Override
    public void notifyEvent(final Event e) {
        
    }
    /**
     * 
     */
    @Override
    public ViewManager get() {
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
        // TODO Auto-generated method stub

    }
    /**
     * 
     */
    @Override
    public void setWidth(final int w) {
        // TODO Auto-generated method stub

    }
    /**
     * 
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub

    }
}
