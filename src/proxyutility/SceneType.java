package proxyutility;
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
    PAUSE("PauseView.fxml"),
    /**
     * Leader-board scene.
     */
    LEADERBOARD("LeaderboardView.fxml"),
    /**
     * New game scene.
     */
    NEWGAME("NewGameView.fxml");
    private String file;
    SceneType(final String file) {
        this.file = file;
    }
    /**
     * Get File name.
     * @return file name.
     */
    public String getFile() {
        return file;
    }
}

