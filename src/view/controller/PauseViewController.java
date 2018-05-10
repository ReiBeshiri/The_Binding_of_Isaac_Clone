package view.controller;

import java.util.Arrays;

import controller.event.ButtonType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import proxyutility.SceneType;
import view.MainMenuScene;
import view.ViewManagerImpl;
/**
 * 
 * Controller class for the PauseView file.
 *
 */
public class PauseViewController extends AbstractControllerFXML {

    @FXML
    private BorderPane contentPane;
    @FXML 
    private Button exitButton;
    @FXML 
    private Button resumeButton;
    
    @Override
    public Region getRoot() {
        return contentPane;
    }

    @FXML
    private void inizialize() {
        super.setButtonNotification(Arrays.asList(ButtonType.PAUSE_GAME, ButtonType.QUIT_GAME), SceneType.PAUSE);
    }
    
    @FXML
    private void resumeButtonClick() {
        super.closingFade(()-> ViewManagerImpl.get().pop());
    }
    @FXML
    private void exitButtonClick() {
        super.closingFade(()->ViewManagerImpl.get().push(new MainMenuScene()));
     }
}
