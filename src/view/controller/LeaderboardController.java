package view.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.ViewManagerImpl;

public class LeaderboardController extends AbstractControllerFXML{

    @FXML
    private BorderPane contentPane;

    @FXML
    private void backButtonClick() {
        super.closingFade(()->ViewManagerImpl.get().pop());
    }
    
    @Override
    public Region getRoot() {
        return this.contentPane;
    }

}
