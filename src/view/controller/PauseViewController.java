package view.controller;

import controller.event.ButtonEventImpl;
import controller.utility.ButtonType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.MainMenuScene;
import view.ViewImpl;
import view.ViewManagerImpl;
import view.utility.ViewUtils;

/**
 * 
 * Controller class for the PauseView file.
 *
 */
public class PauseViewController extends AbstractControllerFXML {

    @FXML private BorderPane contentPane;
    @FXML private Button exitButton;
    @FXML private Button resumeButton;
    @FXML private Label scoreLabel;
    @FXML private Label damageLabel;
    @FXML private Label velLabel;
    @FXML private Label bulletRangeLabel;

    @FXML
    private void initialize() {
        scoreLabel.setText("");
        damageLabel.setText("");
        velLabel.setText("");
        bulletRangeLabel.setText("");
    }

    @Override
    public final Region getRoot() {
        return contentPane;
    }

    @FXML
    private void resumeButtonClick() {
        ViewManagerImpl.get().pop();
        ViewImpl.get().notifyEvent(new ButtonEventImpl(ButtonType.RESUME_GAME, ""));
    }

    @FXML
    private void exitButtonClick() {
        ViewImpl.get().notifyEvent(new ButtonEventImpl(ButtonType.RETURN_MAIN_MENU, ""));
        while (!(ViewManagerImpl.get().getCurrentScene() instanceof MainMenuScene)) {
            ViewManagerImpl.get().pop();
        }
    }
}
