package input;
/**
 * Scenes of the game.
 * 
 */
public enum SceneType {
    /**
     * Start scene.
     */
    MENU("MainMenuView.fxml"),
    /**
     * Option scene.
     */
    OPTIONS("OptionsMenuView.fxml"),
    /**
     * Credits scene.
     */
    CREDITS("CreditsView.fxml"),
    /**
     * Help scene.
     */
    HELP("HelpView.fxml"),
    /**
     * End game scene.
     */
    ENDGAME("EndGameView.fxml"),
    /**
     * Game main scene.
     */
    GAME("GameCanvasView.fxml"),
    /**
     * Pause scene.
     */
    PAUSE("PauseView.fxml");
    private String file;
    SceneType(final String file) {
        this.file = file;
    }
    private String getFile() {
        return file;
    }
}

