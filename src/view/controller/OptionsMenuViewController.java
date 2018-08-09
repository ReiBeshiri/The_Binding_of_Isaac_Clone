package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.ViewManagerImpl;
import view.utility.ViewUtils;

/**
 * 
 * Controller class for the OptionsMenuView file.
 *
 */
public class OptionsMenuViewController extends AbstractControllerFXML {

    @FXML private CheckBox godModeCheckBox;
    @FXML private CheckBox survivalModeCheckBox;
    @FXML private BorderPane contentPane;

    /**
     * Initialize method that loads previous configuration.
     */
    @FXML
    public void initialize() {
        godModeCheckBox.setSelected(ViewUtils.isGodModeSelected());
        survivalModeCheckBox.setSelected(ViewUtils.isSurvivalModeSelected());
    }

    /**
     * Event method to close the displayed view and save the changes.
     */
    @FXML
    public void applyButtonClick() {
        ViewUtils.setGodMode(godModeCheckBox.isSelected());
        ViewUtils.setSurvivalMode(survivalModeCheckBox.isSelected());
        ViewManagerImpl.get().pop();
    }

    /**
     * Event method to close the displayed view.
     */
    @FXML
    public void exitButtonClick() {
        godModeCheckBox.setSelected(ViewUtils.isGodModeSelected());
        survivalModeCheckBox.setSelected(ViewUtils.isSurvivalModeSelected());
        ViewManagerImpl.get().pop();
    }

    /**
     * Get root.
     */
    @Override
    public final Region getRoot() {
        return this.contentPane;
    }

    /**
     * Set text.
     */
    @Override
    public void setText() { }
}
