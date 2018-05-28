package view;

import controller.event.Event;
import javafx.stage.Stage;
/**
 * Class that manage different types of view.
 * 
 */
public interface ViewManager {
    /**
     * Push generic scene in scene stack.
     * @param scene Scene to push.
     */
    void push(GenericScene scene);
    /**
     * Pop last added-element in scene stack. 
     */
    void pop();
    /**
     * Notify event to view.
     * @param e Event to be notified.
     */
    void notifyEvent(Event e);
    /**
     * Set stage height.
     * @param h Height.
     */
    void setHeight(int h);
    /**
     * Set stage width.
     * @param w Width.
     */
    void setWidth(int w);
    /**
     * Active scene.
     * @return Get current scene.
     */
    GenericScene getCurrentScene();
    /**
     * Redraw scene.
     */
    void updateViewState();
    /**
     * Get stage.
     * @return stage.
     */
    Stage getMainStage();
}
