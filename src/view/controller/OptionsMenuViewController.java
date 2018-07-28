package view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.ViewManagerImpl;
import view.util.ViewUtils;
import view.util.Tupla;
/**
 * 
 * Controller class for the OptionsMenuView file.
 *
 */
public class OptionsMenuViewController extends AbstractControllerFXML {
    @FXML 
    private CheckBox godModeCheckBox;
    @FXML 
    private BorderPane contentPane;

    @FXML
    private void initialize() {
        godModeCheckBox.setSelected(ViewUtils.isGodModeSelected());
    }

    @FXML
    private void applyButtonClick() {
        ViewUtils.setGodMode(godModeCheckBox.isSelected());
        super.closingFade(() -> ViewManagerImpl.get().pop());
    }

    @FXML
    private void exitButtonClick() {
        //super.closingFade(() -> ViewManagerImpl.get().pop());
        ViewManagerImpl.get().pop();
    }

    @Override
    public final Region getRoot() {
        return this.contentPane;
    }
}
