package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
/**
 * Controller class for the EndGameView file.
 */
public class EndGameViewController extends AbstractControllerFXML{

    @FXML
    private BorderPane contentPane;
    @FXML
    private TextField nicknameText;
    
    public EndGameViewController() {
    }

    @FXML
    private void exitButtonClick() {
        //ViewManager close & POP
    }
    
    @FXML
    private void saveButtonClick() {
        //Save points and nickname
    }
    @Override
    public Region getRoot() {
        return contentPane;
    }

}
