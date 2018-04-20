package input;
/**
 * Scenes of the game.
 * 
 */
public enum ScenePanel {
    /**
     * Start scene.
     */
    MENU("MainMenuView.fxml"),
    /**
     * Option scene.
     */
    OPTIONS("OptionsMenuView.fxml"),
    /**
     * credit scene.
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
     * 
     */
    PAUSE("TODO");
    
    
    private String file;
    ScenePanel(final String file) {
        this.file=file;
    }
    private String getFile() {
        return file;
    }
}

