package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
/**
 * Controller class for the EndGameView file.
 */
public class EndGameViewController extends AbstractControllerFXML{

    @FXML
    private BorderPane contentPane;
    @FXML
    private TextField nicknameText;
    
    public EndGameViewController() {
    }

    @FXML
    private void exitButtonClick() {
        //super.closingFade(() -> ViewManager.Pop()); DOBBIAMO GESTIRE LA CHIUSURA. 
                                                    //(qui in teoria lo stack rimane vuoto)
                                                    //una possibile soluzione sarebbe che all'avvio del gioco
                                                    //si fa una push nello stack relativo al menu principale.
    }
    
    @FXML
    private void saveButtonClick() {
        //super.closingFade(() -> ViewManager.Pop()); DOBBIAMO GESTIRE LA CHIUSURA. 
    }
    @Override
    public Region getRoot() {
        return contentPane;
    }

}
