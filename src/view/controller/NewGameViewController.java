package view.controller;

import controller.event.ButtonEventImpl;
import controller.util.ButtonType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.ViewImpl;
import view.ViewManagerImpl;
import view.util.SceneFactory;

/**
 * 
 * Controller class for the NewGameView file.
 *
 */
public class NewGameViewController extends AbstractControllerFXML {

    @FXML private BorderPane contentPane;
    @FXML private Button btnBack;
    @FXML private Button btnPlay;
    @FXML private TextField txtNickname;

    @Override
    public final Region getRoot() {
        return this.contentPane;
    }

    @FXML
    private void btnPlayClick() {
        if (!txtNickname.getText().isEmpty()) {
            ViewManagerImpl.get().pop();
            ViewManagerImpl.get().push(SceneFactory.createGameScene());
            ViewImpl.get().notifyEvent(new ButtonEventImpl(ButtonType.START_GAME, txtNickname.getText()));
        }
    }

    @FXML
    private void btnBackClick() {
        //super.closingFade(() -> ViewManagerImpl.get().pop());
        ViewManagerImpl.get().pop();
    }

}
