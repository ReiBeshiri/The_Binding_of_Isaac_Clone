package view.controller;

import controller.event.ButtonEventImpl;
import controller.util.ButtonType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.MainMenuScene;
import view.ViewImpl;
import view.ViewManagerImpl;

/**
 * 
 * Controller class for the PauseView file.
 *
 */
public class PauseViewController extends AbstractControllerFXML {

    @FXML private BorderPane contentPane;
    @FXML private Button exitButton;
    @FXML private Button resumeButton;

    @Override
    public final Region getRoot() {
        return contentPane;
    }

    @FXML
    private void resumeButtonClick() {
        // super.closingFade(() -> ViewManagerImpl.get().pop());
        ViewManagerImpl.get().pop();
        ViewImpl.get().notifyEvent(new ButtonEventImpl(ButtonType.RESUME_GAME, ""));
    }

    @FXML
    private void exitButtonClick() {
        // super.closingFade(() -> ViewManagerImpl.get().push(new MainMenuScene()));
        ViewImpl.get().notifyEvent(new ButtonEventImpl(ButtonType.RETURN_MAIN_MENU, ""));
        while (!(ViewManagerImpl.get().getCurrentScene() instanceof MainMenuScene)) {
            ViewManagerImpl.get().pop();
        }
        // ViewManagerImpl.get().push(SceneFactory.createMenuScene());
    }
}
