package view.controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
/**
 * Controller class for the HelpView file.
 */
public class GameCanvasViewController extends AbstractControllerFXML {

    @FXML
    private FlowPane rootGamePane;
    @FXML
    private Canvas roomCanvas;
    @FXML
    private Canvas elapsedTimeCanvas;

    @FXML
    private void inizialize() {
        //Assegnazione del "Disegnatore" e passaggio di tale drower all viewimpl
        /*
         disegnatore = new disegnatoreImpl(roomCanvas, elapsedTimeCanvas);
         ViewImpl.PassoNuovoDisegnatore(disegnatore);
        */
    }

    @Override
    public final Region getRoot() {
        return rootGamePane;
    }

    /**
     * Main canvas.
     * @return Canvas where paint scene.
     */
    public Canvas getGameCanvas() {
        return roomCanvas;
    }

}
