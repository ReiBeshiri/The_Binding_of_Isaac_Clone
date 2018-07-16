package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.ViewManagerImpl;
import view.util.ViewUtil;
import view.util.Tupla;
/**
 * 
 * Controller class for the OptionsMenuView file.
 *
 */
public class OptionsMenuViewController extends AbstractControllerFXML {
    @FXML
    private ComboBox<String> resolutionComboBox;
    @FXML 
    private ComboBox<String> fpsComboBox;
    @FXML 
    private CheckBox godModeCheckBox;
    @FXML 
    private BorderPane contentPane;

    private static final Tupla<Integer, Integer> LOW_RES = new Tupla<>(800, 450);
    private static final Tupla<Integer, Integer> MEDIUM_RES = new Tupla<>(1280, 720);
    private static final Tupla<Integer, Integer> HIGH_RES = new Tupla<>(1920, 1080);
    private static final Tupla<Integer, Integer> ULTRA_RES = new Tupla<>(3840, 2160);

    @FXML
    private void initialize() {
        resolutionComboBox.setValue(ViewUtil.getSelectedRes().getWidth() + "x" + ViewUtil.getSelectedRes().getHeight());
        fpsComboBox.setValue(Integer.toString(ViewUtil.getFps()));
        godModeCheckBox.setSelected(ViewUtil.isGodModeSelected());
    }

    @FXML
    private void applyButtonClick() {
        final String resSelected = resolutionComboBox.getValue();
        if (resSelected.equals("800x450")) {
            ViewUtil.setResolution(LOW_RES);
        } else if (resSelected.equals("1280x720")) {
            ViewUtil.setResolution(MEDIUM_RES);
        } else if (resSelected.equals("1920x1080")) {
            ViewUtil.setResolution(HIGH_RES);
        } else if (resSelected.equals("3840x2160")) {
            ViewUtil.setResolution(ULTRA_RES);
        }

        ViewUtil.setFps(Integer.parseInt(fpsComboBox.getSelectionModel().getSelectedItem()));
        ViewUtil.setGodMode(godModeCheckBox.isSelected());

        //ViewManager.RESIZE

        super.closingFade(() -> ViewManagerImpl.get().pop());
    }

    @FXML
    private void exitButtonClick() {
        super.closingFade(() -> ViewManagerImpl.get().pop());
    }

    @Override
    public final Region getRoot() {
        return this.contentPane;
    }
}
