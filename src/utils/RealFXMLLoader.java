package utils;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import view.controller.ControllerFXML;
/**
 * 
 *
 */
public class RealFXMLLoader implements LoaderFXML {
    private static final String PATH = "/res";
    private final FXMLLoader loader;
    /**
     * 
     */
    public RealFXMLLoader() {
        loader = new FXMLLoader();
    }
    /**
     * 
     */
    @Override
    public ControllerFXML getFXMLController(final SceneType scene) {
        ControllerFXML controllerFXML;
        try {
            loader.load(getClass().getResourceAsStream(PATH + scene.getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        controllerFXML = loader.getController();
        return controllerFXML;
    }

}
