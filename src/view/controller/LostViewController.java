package view.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.MainMenuScene;
import view.ViewManagerImpl;

/**
 * Controller class for the WinView file.
 */
public class LostViewController extends AbstractControllerFXML {

    @FXML private BorderPane contentPane;

    @FXML
    private void okButtonClick() {
        //ViewManagerImpl.get().pop();
        //ViewManagerImpl.get().push(SceneFactory.createEndGameScene());
        while (!(ViewManagerImpl.get().getCurrentScene() instanceof MainMenuScene)) {
            ViewManagerImpl.get().pop();
        }
    }

    @Override
    public final Region getRoot() {
        return contentPane;
    }
}
