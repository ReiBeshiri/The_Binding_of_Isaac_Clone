package view.controller;

import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
//import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
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
    
    public MainMenuViewController() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public Region getRoot() {
        return contentPane;
    }

    @FXML
    private void initialize() {
        super.setButtonNotification(Arrays.asList(playButton, optionsButton, exitButton, helpButton, creditsButton), "MainMenu");
    }
    @FXML
    private void playButtonClick() {
        //PUSH a "Play Game" in stack
    }
    
    @FXML
    private void optionsButtonClick() {
        //PUSH a "Options Menu" in stack
    }
    
    @FXML
    private void exitButtonClick() {
        //PUSH a "Exit Game" in stack
    }
    
    @FXML
    private void helpButtonClick() {
        //PUSH a "Help Menu" in stack
    }
    
    @FXML
    private void creditsButtonClick() {
        //PUSH a "Credits" in stack
    }
}
