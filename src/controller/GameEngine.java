package controller;
/**
 * Interface that manages all game situations.
 */
public interface GameEngine {
    /**
     * Initialize the view for the kts application.
     */
    void initView();
    /**
     * Create a new game.
     */
    void newGame();
    /**
     * Stop the game.
     */
    void stopGame();
    /**
     * Resume the execution of the game.
     */
    void resumeGameLoop();
    /**
     * The player has lost.
     */
    void gameOver();
    /**
     * The player has won.
     */
    void victory();
    /**
     * @return the gameLoop object.
     */
    GameLoop getGameLoop();
}
