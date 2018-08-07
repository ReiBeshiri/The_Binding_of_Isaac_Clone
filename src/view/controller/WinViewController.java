package view.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.ViewManagerImpl;
import view.util.SceneFactory;
/**
 * Controller class for the WinView file.
 */
public class WinViewController extends AbstractControllerFXML {

    @FXML private BorderPane contentPane;

    @FXML
    private void okButtonClick() {
        ViewManagerImpl.get().pop();
        ViewManagerImpl.get().push(SceneFactory.createEndGameScene());
    }

    @Override
    public final Region getRoot() {
        return contentPane;
    }

}
