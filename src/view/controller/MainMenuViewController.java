package view.controller;

import controller.event.ButtonEventImpl;
import controller.util.ButtonType;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
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
    
    @Override
    public Region getRoot() {
        return contentPane;
    }

    @FXML
    private void playButtonClick() {
        ViewManagerImpl.get().push(new GameScene());
        ViewManagerImpl.get().notifyEvent(new ButtonEventImpl(ButtonType.START_GAME));
    }
    
    @FXML
    private void optionsButtonClick() {
        ViewManagerImpl.get().push(new OptionScene());
    }
    
    @FXML
    private void exitButtonClick() {
        ViewManagerImpl.get().pop();
        ViewManagerImpl.get().notifyEvent(new ButtonEventImpl(ButtonType.QUIT_GAME));
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
