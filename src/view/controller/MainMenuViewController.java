package view.controller;

import controller.event.ButtonEventImpl;
import controller.util.ButtonType;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.ViewImpl;
import view.ViewManagerImpl;
import view.utility.SceneFactory;
/**
 * 
 * Controller class for the MainMenuView file.
 *
 */
public class MainMenuViewController extends AbstractControllerFXML {

    @FXML private BorderPane contentPane;

    @Override
    public final Region getRoot() {
        return contentPane;
    }

    @FXML
    private void playButtonClick() {
        ViewManagerImpl.get().push(SceneFactory.createNewGameScene());
    }

    @FXML
    private void optionsButtonClick() {
        ViewManagerImpl.get().push(SceneFactory.createOptionScene());
    }

    @FXML
    private void exitButtonClick() {
        ViewManagerImpl.get().pop();
        ViewImpl.get().notifyEvent(new ButtonEventImpl(ButtonType.QUIT_GAME, ""));
    }

    @FXML
    private void helpButtonClick() {
        ViewManagerImpl.get().push(SceneFactory.createHelpScene());
    }

    @FXML
    private void creditsButtonClick() {
        ViewManagerImpl.get().push(SceneFactory.createCreditScene());
    }

    @FXML
    private void btnLeaderboardClick() {
        ViewManagerImpl.get().push(SceneFactory.createLeaderboardScene());
    }
}
