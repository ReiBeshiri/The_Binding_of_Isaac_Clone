package view;

import input.InputCommandType;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import utils.SceneType;
import view.controller.ControllerFXML;

/**
 * Class that represent a generic scene.
 * Some method need to be defined in a specific concrete subclass.
 */
public abstract class AbstractGenericScene {
    private final SceneType scene;
    private ControllerFXML controller;
    private final EventHandler<KeyEvent> sceneHandler;
    /**
     * Constructor for a generic scene.
     * @param s Scene type.
     */
    public AbstractGenericScene(final SceneType s) {
        scene = s;
        //Caricare la scena con il proxy.
        sceneHandler = e -> {
            if (e.getCode().toString().equals(InputCommandType.Esc.toString()) 
                    && e.getEventType().equals(KeyEvent.KEY_PRESSED)) {
                exitStatus();
            }
            checkSceneHandler(e);
        };
    }
    /**
     * Method called when 'esc' command in pressed.
     * It depends on a type of scene.
     */
    public abstract void exitStatus();
    /**
     * Method used to check key events when handler captures these.
     * It depends on a type of scene.
     * @param e Event captured by the handler.
     */
    public abstract void checkSceneHandler(Event e);
    /**
     * Get the scene type.
     * @return The type of scene, represented by a enum type.
     */
    public SceneType getSceneType() {
        return this.scene;
    }
    /**
     * Getter for a event handler.
     * @return The event handler for the scene.
     */
    public EventHandler<KeyEvent> getEventHandler() {
        return this.sceneHandler;
    }
    /**
     * Get controller FXML.
     * @return the controller.
     */
    public ControllerFXML getSceneController() {
        return controller;
    }
}
