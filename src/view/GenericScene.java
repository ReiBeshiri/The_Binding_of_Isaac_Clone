package view;

import input.SceneType;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
/**
 * generic type of scene.
 */
public interface GenericScene {
    /**
     * getter for a scene represented by this class.
     * @return enum type of this scene.
     */
    SceneType getSceneType();
    /**
     * return event handler of that scene.
     * @return event handler.
     */
    EventHandler<KeyEvent> getEventHandler();
    /**
     * Check specific type of events.
     * @param e Event received.
     */
    void checkSceneHandler(Event e);
    /**
     * Add exit status to scene stack.
     */
    void exitStatus();
}
