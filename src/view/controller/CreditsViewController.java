package view.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
/**
 * Controller class for the CreditsView file.
 */
public class CreditsViewController extends AbstractControllerFXML{

    @FXML
    private BorderPane contentPane;
    
    public CreditsViewController() {
    }

    @FXML
    private void backButtonClick() {
        //ViewManager close & POP
    }
    
    @Override
    public Region getRoot() {
        return contentPane;
    }

}
