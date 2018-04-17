package view.controller;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
/**
 * Abstract class with the common behavior to all controller classes.
 * CI SERVE SE VOGLIAMO APPICARE IL PATTERN OBSERVER (?)
 * Vogliamo le animazioni (fade o magari altro) in apertura e chiusura??? se si, vanno qui.
 */
public abstract class AbstractControllerFXML {

    /**
     * Getter of the root node for the FXML file.
     * @return The root element.
     */
    public abstract Region getRoot();
    
    /**
     * Method to set buttons behavior.
     * @param sceneButtons
     *          List of buttons that can generate an event.
     * @param sceneName
     *          The current scene.
     */
    protected void setButtonNotification(final List<Button> sceneButtons, final String sceneName) {
        this.getRoot().addEventFilter(ActionEvent.ACTION, filter->{
            sceneButtons.stream().forEach(a -> {
                if(a.equals(filter.getTarget())) {
                    //ViewManager.sendEvent(new buttonEvent(?.?.?));
                }
            });
        });
    }
}
