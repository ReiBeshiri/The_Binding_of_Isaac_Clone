package view.controller;

import controller.event.ButtonEventImpl;
import controller.utility.ButtonType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.ViewImpl;
import view.ViewManagerImpl;
import view.scene.MainMenuScene;
import view.utility.ViewUtils;

/**
 * 
 * Controller class for the PauseView file.
 *
 */
public class PauseViewController extends AbstractControllerFXML {

    @FXML private BorderPane contentPane;
    @FXML private Button exitButton;
    @FXML private Button resumeButton;
    @FXML private Label scoreLabel;
    @FXML private Label damageLabel;
    @FXML private Label velLabel;
    @FXML private Label bulletRangeLabel;

    @FXML
    private void initialize() {
//        scoreLabel.setText(Integer.toString(ViewUtils.getStats().getPoints()));
//        damageLabel.setText(Integer.toString(ViewUtils.getStats().getBulletDamage()));
//        velLabel.setText(Double.toString(ViewUtils.getStats().getVel()));
//        bulletRangeLabel.setText(Double.toString(ViewUtils.getStats().getBulletRange()));
    }

    /**
     * Get root.
     */
    @Override
    public final Region getRoot() {
        return contentPane;
    }

    /**
     * Set text.
     */
    @Override
    public void setText() {
        scoreLabel.setText(Integer.toString(ViewUtils.getStats().getPoints()));
        damageLabel.setText(Integer.toString(ViewUtils.getStats().getBulletDamage()));
        velLabel.setText(Double.toString(ViewUtils.getStats().getVel()));
        bulletRangeLabel.setText(Double.toString(ViewUtils.getStats().getBulletRange()));
    }

    @FXML
    private void resumeButtonClick() {
        ViewManagerImpl.get().pop();
        ViewImpl.get().notifyEvent(new ButtonEventImpl(ButtonType.RESUME_GAME, ""));
    }

    @FXML
    private void exitButtonClick() {
        ViewImpl.get().notifyEvent(new ButtonEventImpl(ButtonType.RETURN_MAIN_MENU, ""));
        while (!(ViewManagerImpl.get().getCurrentScene() instanceof MainMenuScene)) {
            ViewManagerImpl.get().pop();
        }
    }
}
