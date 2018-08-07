package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.MainMenuScene;
import view.ViewManagerImpl;

/**
 * Controller class for the WinView file.
 */
public class WinViewController extends AbstractControllerFXML {

    @FXML private BorderPane contentPane;
    @FXML private TextField scoreText;

    @FXML
    private void initialize() {
        scoreText.setText("WIN");
    }

    @FXML
    private void okButtonClick() {
        while (!(ViewManagerImpl.get().getCurrentScene() instanceof MainMenuScene)) {
            ViewManagerImpl.get().pop();
        }
    }

    @Override
    public final Region getRoot() {
        return contentPane;
    }

}
