package view.controller;
import controller.event.ButtonEventImpl;
import controller.util.ButtonType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.ViewImpl;
import view.ViewManagerImpl;
import view.util.SceneFactory;
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
    public final Region getRoot() {
        return contentPane;
    }

    @FXML
    private void resumeButtonClick() {
        //super.closingFade(() -> ViewManagerImpl.get().pop());
        ViewManagerImpl.get().pop();
    }

    @FXML
    private void exitButtonClick() {
        //super.closingFade(() -> ViewManagerImpl.get().push(new MainMenuScene()));
        ViewImpl.get().notifyEvent(new ButtonEventImpl(ButtonType.RETURN_MAIN_MENU, ""));
        ViewManagerImpl.get().push(SceneFactory.createMenuScene());
     }
}
