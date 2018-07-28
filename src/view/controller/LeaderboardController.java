package view.controller;

import controller.util.Score;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import view.ViewManagerImpl;
import view.util.ViewUtils;

/**
 * Controller class for the LeaderboardView file.
 *
 */
public class LeaderboardController extends AbstractControllerFXML {

    @FXML
    private TableView<Score> table;
    @FXML
    private TableColumn<Score, String> nicknameColumn;
    @FXML
    private TableColumn<Score, Integer> pointsColumn;
    @FXML
    private TableColumn<Score, String> timeColumn;
    @FXML
    private BorderPane contentPane;

    @FXML
    private void backButtonClick() {
        //super.closingFade(() -> ViewManagerImpl.get().pop());
        ViewManagerImpl.get().pop();
    }

    @FXML
    private void initialize() {
        nicknameColumn.setText("Nickname");
        pointsColumn.setText("Points");
        timeColumn.setText("Time");
        table.getItems().setAll(ViewUtils.getScoreBoard().getScoreList());
    }

    @Override
    public final Region getRoot() {
        return this.contentPane;
    }

}
