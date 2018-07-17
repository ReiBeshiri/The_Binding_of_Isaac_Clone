package view.controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import view.DrawerManager;
import view.DrawerManagerImpl;
import view.ViewImpl;
/**
 * Controller class for the HelpView file.
 */
public class GameCanvasViewController extends AbstractControllerFXML {

    @FXML
    private FlowPane rootGamePane;
    @FXML
    private Canvas roomCanvas;
    @FXML
    private Canvas lifesCanvas;
    @FXML
    private Canvas elapsedTimeCanvas; 

    /**
     * 
     */
    @FXML
    public void inizialize() {
        final DrawerManager drawer = new DrawerManagerImpl(roomCanvas, elapsedTimeCanvas, lifesCanvas);
        ViewImpl.get().setDrawer(drawer);
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
