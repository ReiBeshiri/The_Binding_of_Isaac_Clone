package view.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.ViewManagerImpl;
/**
 * 
 * Controller class for the HelpView file.
 *
 */
public class HelpViewController extends AbstractControllerFXML {

    @FXML private BorderPane contentPane;

    @FXML
    private void backButtonClick() {
        //super.closingFade(() -> ViewManagerImpl.get().pop());
        ViewManagerImpl.get().pop();
    }

    @Override
    public final Region getRoot() {
        return contentPane;
    }

}
