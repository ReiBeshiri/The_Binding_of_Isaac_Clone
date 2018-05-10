package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.ViewManagerImpl;
/**
 * Controller class for the EndGameView file.
 */
public class EndGameViewController extends AbstractControllerFXML{

    @FXML
    private BorderPane contentPane;
    @FXML
    private TextField nicknameText;

    @FXML
    private void exitButtonClick() {
        super.closingFade(() -> ViewManagerImpl.get().pop());
    }

    @FXML
    private void saveButtonClick() {
        //super.closingFade(() -> ViewManager.Pop()); DOBBIAMO GESTIRE IL SALVATAGGIO. 
    }

    @Override
    public Region getRoot() {
        return contentPane;
    }

}
