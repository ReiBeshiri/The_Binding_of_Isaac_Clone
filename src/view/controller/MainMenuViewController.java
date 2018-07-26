package view.controller;

import controller.event.ButtonEventImpl;
import controller.util.ButtonType;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.CreditScene;
import view.HelpScene;
import view.LeaderboardScene;
import view.NewGameScene;
import view.OptionScene;
import view.ViewImpl;
import view.ViewManagerImpl;
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
        ViewManagerImpl.get().push(new NewGameScene());
    }

    @FXML
    private void optionsButtonClick() {
        ViewManagerImpl.get().push(new OptionScene());
    }

    @FXML
    private void exitButtonClick() {
        ViewManagerImpl.get().pop();
        ViewImpl.get().notifyEvent(new ButtonEventImpl(ButtonType.QUIT_GAME, ""));
    }

    @FXML
    private void helpButtonClick() {
        ViewManagerImpl.get().push(new HelpScene());
    }

    @FXML
    private void creditsButtonClick() {
        ViewManagerImpl.get().push(new CreditScene());
    }
    
    @FXML
    private void btnLeaderboardClick() {
        ViewManagerImpl.get().push(new LeaderboardScene());
    }
}
