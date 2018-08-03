package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.ViewManagerImpl;
import view.util.ViewUtils;

/**
 * 
 * Controller class for the OptionsMenuView file.
 *
 */
public class OptionsMenuViewController extends AbstractControllerFXML {

    @FXML private CheckBox godModeCheckBox;
    @FXML private CheckBox infinityModeCheckBox;
    @FXML private BorderPane contentPane;

    @FXML
    private void initialize() {
        godModeCheckBox.setSelected(ViewUtils.isGodModeSelected());
        infinityModeCheckBox.setSelected(ViewUtils.isInfinityModeSelected());
    }

    @FXML
    private void applyButtonClick() {
        ViewUtils.setGodMode(godModeCheckBox.isSelected());
        ViewUtils.setInfinityMode(infinityModeCheckBox.isSelected());
        //super.closingFade(() -> ViewManagerImpl.get().pop());
        ViewManagerImpl.get().pop();
    }

    @FXML
    private void exitButtonClick() {
        godModeCheckBox.setSelected(ViewUtils.isGodModeSelected());
        infinityModeCheckBox.setSelected(ViewUtils.isInfinityModeSelected());
        //super.closingFade(() -> ViewManagerImpl.get().pop());
        ViewManagerImpl.get().pop();
    }

    @Override
    public final Region getRoot() {
        return this.contentPane;
    }
}
