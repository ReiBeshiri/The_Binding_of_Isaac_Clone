package view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.ViewManagerImpl;
/**
 * Controller class for the CreditsView file.
 */
public class CreditsViewController extends AbstractControllerFXML {

    @FXML private BorderPane creditsContentPane;

    @FXML
    private void backButtonClick() {
        ViewManagerImpl.get().pop();
    }

    /**
     * Get root.
     */
    @Override
    public final Region getRoot() {
        return creditsContentPane;
    }

    /**
     * Set text.
     */
    @Override
    public void setText() { }

}
