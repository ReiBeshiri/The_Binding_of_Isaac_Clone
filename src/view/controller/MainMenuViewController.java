package view.controller;

import java.util.Arrays;

import controller.event.ButtonType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
//import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import proxyutility.SceneType;
import view.CreditScene;
import view.GameScene;
import view.HelpScene;
import view.OptionScene;
import view.ViewManagerImpl;
/**
 * 
 * Controller class for the MainMenuView file.
 *
 */
public class MainMenuViewController extends AbstractControllerFXML {

    @FXML private BorderPane contentPane;
    @FXML private Button playButton;
    @FXML private Button optionsButton;
    @FXML private Button exitButton;
    @FXML private Button helpButton;
    @FXML private Button creditsButton;
    //@FXML private ListView leaderboardView; forse necessita di una sua view. Guarda controllo TableView.
    
    @Override
    public Region getRoot() {
        return contentPane;
    }

    @FXML
    private void initialize() {
        super.setButtonNotification(Arrays.asList(ButtonType.START_GAME, ButtonType.OPTIONS, ButtonType.QUIT_GAME,ButtonType.HELP,
                ButtonType.CREDITS), SceneType.MENU);
    }
    @FXML
    private void playButtonClick() {
        ViewManagerImpl.get().push(new GameScene());
    }
    
    @FXML
    private void optionsButtonClick() {
        ViewManagerImpl.get().push(new OptionScene());
    }
    
    @FXML
    private void exitButtonClick() {
        ViewManagerImpl.get().pop();
    }
    
    @FXML
    private void helpButtonClick() {
        ViewManagerImpl.get().push(new HelpScene());
    }
    
    @FXML
    private void creditsButtonClick() {
        ViewManagerImpl.get().push(new CreditScene());
    }
}
