package view.controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
/**
 * Controller class for the HelpView file.
 */
public class GameCanvasViewController extends AbstractControllerFXML{

    @FXML
    private FlowPane rootGamePane;
    @FXML
    private Canvas roomCanvas;
    
    public GameCanvasViewController() {
    }
    
    @FXML
    private void inizialize() {
        
    }

    @Override
    public Region getRoot() {
        return rootGamePane;
    }

}
