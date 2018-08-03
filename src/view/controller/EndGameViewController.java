package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;

/**
 * Controller class for the EndGameView file.
 */
public class EndGameViewController extends AbstractControllerFXML {

    @FXML private BorderPane contentPane;
    @FXML private TextField nicknameText;
    @FXML private TextField scoreText;

    @FXML
    private void exitButtonClick() {
        //TODO Salvataggio su leadearboard
        //super.closingFade(() -> ViewManagerImpl.get().pop());
        //ViewManagerImpl.get().pop();
    }

    @Override
    public final Region getRoot() {
        return contentPane;
    }

}
