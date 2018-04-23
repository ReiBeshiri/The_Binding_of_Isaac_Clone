package view;

import javafx.event.Event;
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
     * Returns unique instance of this class. Singleton.
     * @return ViewManager singleton.
     */
    ViewManager get();
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
}
