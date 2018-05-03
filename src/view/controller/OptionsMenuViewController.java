package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.util.OptionsViewUtil;
import view.util.Tuple;
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
    
    private static final Tuple<Integer, Integer> LOW_RES = new Tuple<>(800, 450);
    private static final Tuple<Integer, Integer> MEDIUM_RES = new Tuple<>(1280, 720);
    private static final Tuple<Integer, Integer> HIGH_RES = new Tuple<>(1920, 1080);
    private static final Tuple<Integer, Integer> ULTRA_RES = new Tuple<>(3840, 2160);
    
    public OptionsMenuViewController() {
    }
    
    @FXML
    private void initialize() {
        resolutionComboBox.setValue(OptionsViewUtil.getSelectedRes().getWidth() + "x" + OptionsViewUtil.getSelectedRes().getHeight());
        fpsComboBox.setValue(Integer.toString(OptionsViewUtil.getFps()));
        godModeCheckBox.setSelected(OptionsViewUtil.isGodModeSelected());
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
        
        OptionsViewUtil.setFps(Integer.parseInt(fpsComboBox.getSelectionModel().getSelectedItem()));
        OptionsViewUtil.setGodMode(godModeCheckBox.isSelected());
        
        //ViewManager.RESIZE
        
        //super.closingFade(() -> ViewManager.Pop());
    }
    
    @FXML
    private void exitButtonClick() {
       //super.closingFade(() -> ViewManager.Pop());
    }
    
    @Override
    public Region getRoot() {
        return this.contentPane;
    }

}
