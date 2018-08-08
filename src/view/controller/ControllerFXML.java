package view.controller;

import javafx.scene.layout.Region;
/**
 * Interface that provides methods common to all views.
 */
public interface ControllerFXML {

    /**
     * Getter of the root node for the FXML file.
     * @return The root element.
     */
    Region getRoot();

    /**
     * Method used to apply a fade-in transition to a window.
     */
    void openingFade();

    /**
     * Method used to apply a fade-out transition to a window
     * and to set the window that needs to appear.
     * @param toRun
     *          The window that needs to be opened at the end of the transition.
     */
    void closingFade(Runnable toRun);

    /**
     * Set text in different scene.
     */
    void setText();
}
