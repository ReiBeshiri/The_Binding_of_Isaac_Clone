package view.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
/**
 * 
 * Controller class for the HelpView file.
 *
 */
public class HelpViewController extends AbstractControllerFXML {

    @FXML
    private BorderPane contentPane;
    
    @FXML
    private void backButtonClick() {
        //super.closingFade(() -> ViewManager.Pop());
    }
    
    public HelpViewController() {
    }

    @Override
    public Region getRoot() {
        return contentPane;
    }

}
