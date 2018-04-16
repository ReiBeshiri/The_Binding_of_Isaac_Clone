package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import view.util.OptionsViewUtil;
import view.util.Tuple;
/**
 * 
 * WORK IN PROGRESS.... 
 *
 */
public class OptionsMenuViewController {
    @FXML
    private ComboBox<String> resolutionComboBox;
    @FXML 
    private ComboBox<String> fpsComboBox;
    @FXML 
    private CheckBox godModeCheckBox;
    
    private static final Tuple<Integer, Integer> LOW_RES = new Tuple<>(800, 450);
    private static final Tuple<Integer, Integer> MEDIUM_RES = new Tuple<>(1280, 720);
    private static final Tuple<Integer, Integer> HIGH_RES = new Tuple<>(1920, 1080);
    private static final Tuple<Integer, Integer> ULTRA_RES = new Tuple<>(3840, 2160);
    
    public OptionsMenuViewController() {
   
    }
    
    @FXML
    private void applyButtonClick() {
        final String resSelected = resolutionComboBox.getValue();
        if (resSelected.equals("800x450")) {
            OptionsViewUtil.setResolution(LOW_RES);
        } else if (resSelected.equals("1280x720")) {
            OptionsViewUtil.setResolution(MEDIUM_RES);
        } else if (resSelected.equals("1920x1080")) {
            OptionsViewUtil.setResolution(HIGH_RES);
        } else if (resSelected.equals("3840x2160")) {
            OptionsViewUtil.setResolution(ULTRA_RES);
        }
    }

}
