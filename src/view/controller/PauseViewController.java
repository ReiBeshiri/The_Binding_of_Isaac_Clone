package view.controller;

import java.util.Arrays;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
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
        super.setButtonNotification(Arrays.asList(resumeButton, exitButton), "Pause");
    }
    
    @FXML
    private void resumeButtonClick() {
      //super.closingFade(() -> ViewManager.Pop());
    }
    @FXML
    private void exitButtonClick() {
        //super.closingFade(() -> ViewManager.Push(MainMenu));
     }
}
