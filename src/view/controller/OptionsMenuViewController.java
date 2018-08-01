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
    @FXML 
    private CheckBox godModeCheckBox;
    @FXML 
    private CheckBox infinityModeCheckBox;
    @FXML 
    private BorderPane contentPane;

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
        if (godModeCheckBox.isSelected()) {
            ViewUtils.setGodMode(true);
        }
        if (infinityModeCheckBox.isSelected()) {
            ViewUtils.setInfinityMode(true);
        }
        //super.closingFade(() -> ViewManagerImpl.get().pop());
        ViewManagerImpl.get().pop();
        System.out.println(godModeCheckBox.isSelected());
        System.out.println(infinityModeCheckBox.isSelected());
    }

    @Override
    public final Region getRoot() {
        return this.contentPane;
    }
}
